import { Component } from '@angular/core';
import { Usuario } from '../model/usuario';
import { UsuarioService } from '../service/usuario.service';
import { HttpClientModule } from '@angular/common/http';
import { CommonModule } from '@angular/common';
import { RouterLink } from '@angular/router';
import { Router } from '@angular/router';

@Component({
  selector: 'app-cliente',
  imports: [HttpClientModule, CommonModule],
  templateUrl: './usuario.component.html',
  styleUrl: './usuario.component.css',
  providers: [UsuarioService, Router]
})
export class ClienteComponent {

    public listaUsuarios:Usuario[] = [];
    
    constructor(
      private usuarioService:UsuarioService,
      private router:Router
    ){}

    ngOnInit(): void {
      this.usuarioService.getUsuarios().subscribe(resposta => {
          this.listaUsuarios = resposta;
      })
    }
    novo(){
      this.router.navigate(['usuarios/novo'])
    }
    alterar(usuario:Usuario){
      this.router.navigate(['usuarios/alterar', usuario.id])
    }
}