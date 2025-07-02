import { Component } from '@angular/core';
import { Postagem } from '../model/postagem';
import { PostagemService } from '../service/postagem.service';
import { HttpClientModule } from '@angular/common/http';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { Router, ActivatedRoute, ParamMap } from '@angular/router';
import { Usuario } from '../model/usuario';
import { UsuarioService } from '../service/usuario.service';


@Component({
  selector: 'app-form-postagem',
  imports: [HttpClientModule, CommonModule, FormsModule],
  templateUrl: './form-postagem.component.html',
  styleUrl: './form-postagem.component.css',
  providers: [PostagemService, Router, UsuarioService]
})

export class FormPostagemComponent {
    postagem:Postagem = new Postagem();
    
    public listaUsuarios:Usuario[] = [];
    

    constructor(
      private postagemService: PostagemService,
      private UsuarioService: UsuarioService,
      private router: Router,
      private activeRouter: ActivatedRoute
    ) {
        const id = this.activeRouter.snapshot.paramMap.get('id');
        this.UsuarioService.getUsuarios().subscribe(usuarios =>{
            this.listaUsuarios = usuarios;
        });

        if (id) {
          this.postagemService.getPostagemById(id).subscribe(postagem => {
            this.postagem = postagem;
          });
        }
    }

    salvar(){
      this.postagemService.savePostagem(this.postagem)
          .subscribe( res => {
            this.router.navigate(['postagens']);
          });
    }

    comparaUsuarios(obj1: Usuario, obj2: Usuario): boolean {
      return obj1 && obj2 ? obj1.id === obj2.id : obj1 === obj2;
    }
   
    onFileSelected(event: Event): void {
      const input = event.target as HTMLInputElement;
      if (input.files && input.files.length > 0) {
          const file = input.files[0];
          const reader = new FileReader();
          reader.onload = () => {
            const base64String = reader.result as string;
            this.postagem.foto = base64String.split(',')[1]; 
            this.postagem.arquivoFoto = file.name; 
            this.postagem.mimeType = file.type;
          };
          reader.readAsDataURL(file);
      }
  }

}
