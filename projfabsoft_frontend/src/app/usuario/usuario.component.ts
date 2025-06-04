import { Component } from '@angular/core';
import { Usuario } from '../model/usuario';
import { UsuarioService } from '../service/usuario.service';
import { HttpClientModule } from '@angular/common/http';
import { CommonModule } from '@angular/common';
import { RouterLink } from '@angular/router';

@Component({
  selector: 'app-cliente',
  imports: [HttpClientModule, CommonModule, RouterLink],
  templateUrl: './usuario.component.html',
  styleUrl: './usuario.component.css',
  providers: [UsuarioService]
})
export class ClienteComponent {

    public listaUsuarios:Usuario[] = [];
    
    constructor(
      private usuarioService:UsuarioService
    ){}

    ngOnInit(): void {
      this.usuarioService.getUsuarios().subscribe(resposta => {
          this.listaUsuarios = resposta;
      })
    }
}