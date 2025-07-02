import { Component } from '@angular/core';
import { Postagem, Comentario } from '../model/postagem';
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
  comentariosAbertos: { [key: number]: boolean } = {};
  novoComentario: { [key: number]: string } = {};

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
      comentarios: []
    };
    this.postagemService.savePostagem(novaPostagem).subscribe((resposta) => {
      this.listaPostagens.unshift(resposta);
      this.textoPostagem = '';
    });
  }

  toggleComentarios(postagem: Postagem) {
    this.comentariosAbertos[postagem.id] = !this.comentariosAbertos[postagem.id];
  }

  adicionarComentario(postagem: Postagem) {
    if (!this.usuarioSelecionado) return;
    const texto = this.novoComentario[postagem.id]?.trim();
    if (!texto) return;
    const comentario: Comentario = {
      usuario: { id: this.usuarioSelecionado.id, nome: this.usuarioSelecionado.nome },
      texto
    };
    postagem.comentarios = postagem.comentarios || [];
    postagem.comentarios.push(comentario);
    this.postagemService.savePostagem(postagem).subscribe((res) => {
      postagem.comentarios = res.comentarios;
      this.novoComentario[postagem.id] = '';
    });
  }
  toggleLike(postagem: Postagem): void {
    if (!this.usuarioSelecionado) return;
    const userId = this.usuarioSelecionado.id;
    const index = postagem.curtidas.indexOf(userId);
    if (index === -1) {
      postagem.curtidas.push(userId);
    } else {
      postagem.curtidas.splice(index, 1);
    }
    this.postagemService.savePostagem(postagem).subscribe((res) => {
      postagem.curtidas = res.curtidas;
    });
  }
  
  isLikedByUser(postagem: Postagem): boolean {
    if (!this.usuarioSelecionado) return false;
    return postagem.curtidas.includes(this.usuarioSelecionado.id);
  }
}