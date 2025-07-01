import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Postagem } from '../model/postagem';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root',
})
export class PostagemService {
  apiURL = 'http://localhost:8080/api/v1/postagens';

  constructor(private http: HttpClient) {}

  getPostagens(): Observable<Postagem[]> {
    return this.http.get<Postagem[]>(this.apiURL);
  }

  savePostagem(postagem: Postagem): Observable<Postagem> {
    if (postagem.id) {
      return this.http.put<Postagem>(`${this.apiURL}/${postagem.id}`, postagem);
    }
    return this.http.post<Postagem>(this.apiURL, postagem);
  }

  getPostagemById(id: number): Observable<Postagem> {
    return this.http.get<Postagem>(`${this.apiURL}/${id}`);
  }

  excluirPostagem(id: number): Observable<void> {
    return this.http.delete<void>(`${this.apiURL}/${id}`);
  }
}