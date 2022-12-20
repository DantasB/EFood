import { IRestaurante } from '@/shared/model/restaurante.model';
import { IPedido } from '@/shared/model/pedido.model';

export interface IPedir {
  id?: number;
  nomeUsuario?: string | null;
  enderecoUsuario?: string;
  emailUsuario?: string;
  telefoneUsuario?: number | null;
  cpfUsuario?: number | null;
  restaurante?: IRestaurante | null;
  pedido?: IPedido | null;
}

export class Pedir implements IPedir {
  constructor(
    public id?: number,
    public nomeUsuario?: string | null,
    public enderecoUsuario?: string,
    public emailUsuario?: string,
    public telefoneUsuario?: number | null,
    public cpfUsuario?: number | null,
    public restaurante?: IRestaurante | null,
    public pedido?: IPedido | null
  ) {}
}
