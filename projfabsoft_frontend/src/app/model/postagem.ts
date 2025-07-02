export interface Comentario {
  usuario: { id: number, nome: string };
  texto: string;
}

export class Postagem {
    id: number;
    texto: string;
    autor: { id: number, nome: string };
    curtidas: number[];
    comentarios: Comentario[];
}