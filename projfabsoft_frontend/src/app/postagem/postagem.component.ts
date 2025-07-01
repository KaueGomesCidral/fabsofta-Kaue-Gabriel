import { Component } from '@angular/core';
import { Postagem } from '../model/postagem';
import { PostagemService } from '../service/postagem.service';

@Component({
  selector: 'app-postagem',
  templateUrl: './postagem.component.html',
  styleUrls: ['./postagem.component.css'],
})
export class PostagemComponent {
  listaPostagens: Postagem[] = [];

  constructor(private postagemService: PostagemService) {}

  ngOnInit(): void {
    this.postagemService.getPostagens().subscribe((resposta) => {
      this.listaPostagens = resposta;
    });
  }
}