import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Postagem } from '../model/postagem';

@Injectable({
  providedIn: 'root',
})
export class PostagemService {
  apiURL = 'http://localhost:8080/api/v1/postagens';

  constructor(private http: HttpClient) {}

  getPostagens() {
    return this.http.get<Postagem[]>(this.apiURL);
  }

  savePostagem(postagem: Postagem) {
    if (postagem.id) {
      return this.http.put(`${this.apiURL}/${postagem.id}`, postagem);
    }
    return this.http.post(this.apiURL, postagem);
  }

  getPostagemById(id: number) {
    return this.http.get<Postagem>(`${this.apiURL}/${id}`);
  }

  excluirPostagem(id: number) {
    return this.http.delete(`${this.apiURL}/${id}`);
  }
}