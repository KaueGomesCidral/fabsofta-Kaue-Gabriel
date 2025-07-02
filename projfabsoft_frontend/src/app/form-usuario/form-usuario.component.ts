import { Component } from '@angular/core';
import { Usuario } from '../model/usuario';
import { UsuarioService } from '../service/usuario.service';
import { HttpClientModule } from '@angular/common/http';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { Router, ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-form-usuario',
  imports: [HttpClientModule, CommonModule, FormsModule],
  templateUrl: './form-usuario.component.html',
  styleUrls: ['./form-usuario.component.css'],
  providers: [UsuarioService]
})
export class FormUsuarioComponent {
  usuario: Usuario = new Usuario();

  emailInvalido: boolean = false;
  telefoneInvalido: boolean = false;

  constructor(
    private usuarioService: UsuarioService,
    private router: Router,
    private activeRouter: ActivatedRoute
  ) {
    const id = this.activeRouter.snapshot.paramMap.get('id');
    if (id) {
      this.usuarioService.getUsuarioById(id).subscribe(usuario => {
        this.usuario = usuario;
      });
    }
  }

  salvar() {
    this.emailInvalido = !this.validarEmail(this.usuario.email);
    this.telefoneInvalido = !this.validarTelefone(this.usuario.telefone);

    if (this.emailInvalido || this.telefoneInvalido) {
      return;
    }

    this.usuarioService.saveUsuario(this.usuario)
      .subscribe(res => {
        this.router.navigate(['postagens']);
      });
  }

  validarEmail(email: string): boolean {
    const regex = /^[^\s@]+@[^\s@]+\.[^\s@]+$/;
    return regex.test(email);
  }

  validarTelefone(telefone: string): boolean {
    const regex = /^\(\d{2}\)\s\d{4,5}-\d{4}$/;
    return regex.test(telefone);
  }

  formatarTelefone() {
    if (!this.usuario.telefone) return;

    let num = this.usuario.telefone.replace(/\D/g, '');

    if (num.length > 11) {
      num = num.slice(0, 11); 
    }

    if (num.length <= 10) {
      this.usuario.telefone = num.replace(/^(\d{2})(\d{4})(\d{0,4})$/, '($1) $2-$3');
    } else {
      this.usuario.telefone = num.replace(/^(\d{2})(\d{5})(\d{0,4})$/, '($1) $2-$3');
    }
  }

  somenteNumeros(event: KeyboardEvent) {
    const allowedKeys = ['Backspace', 'ArrowLeft', 'ArrowRight', 'Delete', 'Tab'];

    if (
      allowedKeys.includes(event.key) ||
      ((event.ctrlKey || event.metaKey) && ['a', 'c', 'v', 'x'].includes(event.key.toLowerCase()))
    ) {
      return;
    }

    if (!/^\d$/.test(event.key)) {
      event.preventDefault();
    }
  }
}
