import { IPedir } from '@/shared/model/pedir.model';

export interface IPedirProcess {
  id?: number;
  processInstance?: any | null;
  pedir?: IPedir | null;
}

export class PedirProcess implements IPedirProcess {
  constructor(public id?: number, public processInstance?: any | null, public pedir?: IPedir | null) {}
}
