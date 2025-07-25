import { Injectable } from '@angular/core';
import { Usuario } from '../model/usuario';
import { HttpClient } from '@angular/common/http';
import { ClienteComponent } from '../usuario/usuario.component';


@Injectable({
  providedIn: 'root'
})
export class UsuarioService {
  apiURL = "http://localhost:8080/api/v1/usuarios";

  constructor(private http:HttpClient) { }

  getUsuarios(){
     return this.http.get<Usuario[]>(this.apiURL);
  }
  saveUsuario(usuario:Usuario){
    if(usuario.id){
      return this.http.put(this.apiURL + '/' + usuario.id, usuario);
    }
    return this.http.post(this.apiURL,usuario);
  }
  getUsuarioById(id: any) {
    return this.http.get<Usuario>(this.apiURL + '/' + id);
  }
  excluirUsuario(id: any){
    return this.http.delete(this.apiURL + '/' + id + '/deleteAll');
  }
}
