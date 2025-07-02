import { Component, Input } from '@angular/core';
import { CommonModule } from '@angular/common';
import { Usuario } from '../model/usuario';
import { UsuarioService } from '../service/usuario.service';
import { ActivatedRoute, Router, RouterLink } from '@angular/router';
import { FormsModule } from '@angular/forms';

@Component({
  selector: 'app-usuario-detalhe',
  standalone: true,
  imports: [CommonModule, FormsModule, RouterLink],
  templateUrl: './usuario-detalhe.component.html',
  styleUrl: './usuario-detalhe.component.css',
})
export class UsuarioDetalheComponent {
  usuario: Usuario | null = null;
  usuarios: Usuario[] = [];
  edicao: boolean = false;
  mensagem: string = '';

  constructor(
    private usuarioService: UsuarioService,
    private route: ActivatedRoute,
    private router: Router
  ) {}

  ngOnInit(): void {
    this.usuarioService.getUsuarios().subscribe((usuarios) => {
      this.usuarios = usuarios;
      const id = this.route.snapshot.paramMap.get('id');
      if (id) {
        const usuarioEncontrado = usuarios.find(u => u.id == +id);
        if (usuarioEncontrado) {
          this.usuario = usuarioEncontrado;
        }
      }
    });
  }

  selecionarUsuario(event: Event) {
    const select = event.target as HTMLSelectElement;
    const id = Number(select.value);
    const usuarioEncontrado = this.usuarios.find(u => u.id === id);
    if (usuarioEncontrado) {
      this.usuario = usuarioEncontrado;
      this.router.navigate(['/usuarios/detalhe', id]);
    }
  }

  habilitarEdicao() {
    this.edicao = true;
  }

  salvar() {
    if (this.usuario) {
      this.usuarioService.saveUsuario(this.usuario).subscribe(() => {
        this.mensagem = 'Usuário atualizado com sucesso!';
        this.edicao = false;
      });
    }
  }

  excluir() {
    if (this.usuario && confirm('Tem certeza que deseja excluir este usuário?')) {
      this.usuarioService.excluirUsuario(this.usuario.id).subscribe(() => {
        this.router.navigate(['/usuarios']);
      });
    }
  }
}
