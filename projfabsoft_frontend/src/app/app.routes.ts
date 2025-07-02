import { Routes } from '@angular/router';
import { ClienteComponent } from './usuario/usuario.component';
import { FormUsuarioComponent } from './form-usuario/form-usuario.component';
import { PostagemComponent } from './postagem/postagem.component';
import { ChatComponent } from './chat/chat.component';

import { UsuarioDetalheComponent } from './usuario/usuario-detalhe.component';

export const routes: Routes = [
  { path: '', component: ClienteComponent },
  { path: 'usuarios', component: ClienteComponent },
  { path: 'usuarios/novo', component: FormUsuarioComponent },
  { path: 'usuarios/alterar/:id', component: FormUsuarioComponent },
  { path: 'usuarios/detalhe/:id', component: UsuarioDetalheComponent },
  { path: 'postagens', component: PostagemComponent },
  { path: 'chat', component: ChatComponent }
];