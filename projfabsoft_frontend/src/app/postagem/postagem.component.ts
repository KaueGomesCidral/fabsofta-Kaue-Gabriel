import { Component } from '@angular/core';
import { Postagem } from '../model/postagem';
import { PostagemService } from '../service/postagem.service';
import { FormsModule } from '@angular/forms'; // Importação do FormsModule
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-postagem',
  standalone: true, // Indica que o componente é standalone
  imports: [FormsModule, CommonModule], // Adiciona o FormsModule aqui
  templateUrl: './postagem.component.html',
  styleUrls: ['./postagem.component.css'],
})
export class PostagemComponent {
  listaPostagens: Postagem[] = [];
  textoPostagem: string = '';

  constructor(private postagemService: PostagemService) {}

  ngOnInit(): void {
    this.postagemService.getPostagens().subscribe((resposta) => {
      this.listaPostagens = resposta;
    });
  }

  publicarPost(): void {
    if (!this.textoPostagem.trim()) {
      return;
    }

    const novaPostagem: Postagem = {
      id: 0, 
      texto: this.textoPostagem,
      autorId: 2,
      curtidas: [],
    };

    this.postagemService.savePostagem(novaPostagem).subscribe((resposta) => {
      this.listaPostagens.unshift(resposta); // Adiciona a nova postagem no topo da lista
      this.textoPostagem = ''; // Limpa o campo de texto
    });
  }
}