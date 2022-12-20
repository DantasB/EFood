export interface IPedido {
  id?: number;
  nomePedido?: string | null;
  custoPedido?: number | null;
}

export class Pedido implements IPedido {
  constructor(public id?: number, public nomePedido?: string | null, public custoPedido?: number | null) {}
}
