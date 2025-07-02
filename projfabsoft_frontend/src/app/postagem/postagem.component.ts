import { Component } from '@angular/core';
import { Postagem } from '../model/postagem';
import { PostagemService } from '../service/postagem.service';
import { Usuario } from '../model/usuario';
import { UsuarioService } from '../service/usuario.service';
import { FormsModule } from '@angular/forms';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-postagem',
  standalone: true,
  imports: [FormsModule, CommonModule],
  templateUrl: './postagem.component.html',
  styleUrls: ['./postagem.component.css'],
})
export class PostagemComponent {
  listaPostagens: Postagem[] = [];
  textoPostagem: string = '';
  usuarios: Usuario[] = [];
  usuarioSelecionado: Usuario | null = null;

  constructor(
    private postagemService: PostagemService,
    private usuarioService: UsuarioService
  ) {}

  ngOnInit(): void {
    this.postagemService.getPostagens().subscribe((resposta) => {
      this.listaPostagens = resposta;
    });
    this.usuarioService.getUsuarios().subscribe((usuarios) => {
      this.usuarios = usuarios;
      if (usuarios.length > 0) {
        this.usuarioSelecionado = usuarios[0];
      }
    });
  }

  publicarPost(): void {
    if (!this.textoPostagem.trim() || !this.usuarioSelecionado) {
      return;
    }

    const novaPostagem: Postagem = {
      id: 0,
      texto: this.textoPostagem,
      autor: { id: this.usuarioSelecionado.id, nome: this.usuarioSelecionado.nome },
      curtidas: [],
    };

    this.postagemService.savePostagem(novaPostagem).subscribe((resposta) => {
      this.listaPostagens.unshift(resposta);
      this.textoPostagem = '';
    });
  }
}