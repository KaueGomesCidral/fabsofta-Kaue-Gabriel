import { Component } from '@angular/core';
import { Usuario } from '../model/usuario';
import { ClienteService } from '../service/usuario.service';
import { HttpClientModule } from '@angular/common/http';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-cliente',
  imports: [HttpClientModule, CommonModule],
  templateUrl: './usuario.component.html',
  styleUrl: './usuario.component.css',
  providers: [ClienteService]
})
export class ClienteComponent {

    public listaClientes:Usuario[] = [];
    
    constructor(
      private clienteService:ClienteService
    ){}

    ngOnInit(): void {
      this.clienteService.getClientes().subscribe(resposta => {
          this.listaClientes = resposta;
      })
    }
}