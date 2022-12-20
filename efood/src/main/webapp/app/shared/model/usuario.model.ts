export interface IUsuario {
  id?: number;
  nomeUsuario?: string | null;
  enderecoUsuario?: string;
  emailUsuario?: string;
  telefoneUsuario?: number | null;
  cpfUsuario?: number | null;
}

export class Usuario implements IUsuario {
  constructor(
    public id?: number,
    public nomeUsuario?: string | null,
    public enderecoUsuario?: string,
    public emailUsuario?: string,
    public telefoneUsuario?: number | null,
    public cpfUsuario?: number | null
  ) {}
}
