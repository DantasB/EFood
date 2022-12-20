import axios from 'axios';

import { IPedir } from '@/shared/model/pedir.model';

const baseApiUrl = 'api/pedirs';

export default class PedirService {
  public find(id: number): Promise<IPedir> {
    return new Promise<IPedir>((resolve, reject) => {
      axios
        .get(`${baseApiUrl}/${id}`)
        .then(res => {
          resolve(res.data);
        })
        .catch(err => {
          reject(err);
        });
    });
  }

  public retrieve(): Promise<any> {
    return new Promise<any>((resolve, reject) => {
      axios
        .get(baseApiUrl)
        .then(res => {
          resolve(res);
        })
        .catch(err => {
          reject(err);
        });
    });
  }
}
