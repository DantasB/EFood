import axios from 'axios';

import { IPedirProcess } from '@/shared/model/pedir-process.model';

const baseApiUrl = 'api/pedir-processes';

export default class PedirProcessService {
  public find(id: number): Promise<IPedirProcess> {
    return new Promise<IPedirProcess>((resolve, reject) => {
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

  public create(entity: IPedirProcess): Promise<IPedirProcess> {
    return new Promise<IPedirProcess>((resolve, reject) => {
      axios
        .post(`${baseApiUrl}`, entity)
        .then(res => {
          resolve(res.data);
        })
        .catch(err => {
          reject(err);
        });
    });
  }
}
