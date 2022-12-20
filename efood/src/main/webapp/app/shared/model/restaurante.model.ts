export interface IRestaurante {
  id?: number;
  telefoneRestaurante?: number | null;
  emailRestaurante?: string | null;
  ruaRestaurante?: string | null;
  cepRestaurante?: number | null;
  nomeEntregador?: string | null;
  cnpjRestaurante?: number | null;
  nomeRestaurante?: string | null;
}

export class Restaurante implements IRestaurante {
  constructor(
    public id?: number,
    public telefoneRestaurante?: number | null,
    public emailRestaurante?: string | null,
    public ruaRestaurante?: string | null,
    public cepRestaurante?: number | null,
    public nomeEntregador?: string | null,
    public cnpjRestaurante?: number | null,
    public nomeRestaurante?: string | null
  ) {}
}
