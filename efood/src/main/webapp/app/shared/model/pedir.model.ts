export interface IPedir {
  id?: number;
  nomeUsuario?: string | null;
  enderecoUsuario?: string;
  telefoneUsuario?: number | null;
  nomeentregador?: string | null;
  telefonerestaurante?: number | null;
  emailrestaurante?: string | null;
  ruarestaurante?: string | null;
  ceprestaurante?: string | null;
  idPedido?: string | null;
  horaPedido?: string | null;
  custoPedido?: string | null;
}

export class Pedir implements IPedir {
  constructor(
    public id?: number,
    public nomeUsuario?: string | null,
    public enderecoUsuario?: string,
    public telefoneUsuario?: number | null,
    public nomeentregador?: string | null,
    public telefonerestaurante?: number | null,
    public emailrestaurante?: string | null,
    public ruarestaurante?: string | null,
    public ceprestaurante?: string | null,
    public idPedido?: string | null,
    public horaPedido?: string | null,
    public custoPedido?: string | null
  ) {}
}
