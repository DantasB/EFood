import axios from 'axios';
import { EntregaPedidoUserTaskFormContext } from './entrega-pedido-user-task-form.model';

const baseApiUrl = 'api/pedir-process/entrega-pedido-user-task-form';

export default class EntregaPedidoUserTaskFormService {
  public loadContext(taskId: number): Promise<EntregaPedidoUserTaskFormContext> {
    return new Promise<EntregaPedidoUserTaskFormContext>((resolve, reject) => {
      axios
        .get(`${baseApiUrl}/${taskId}`)
        .then(res => {
          resolve(res.data);
        })
        .catch(err => {
          reject(err);
        });
    });
  }

  public claim(taskId: number): Promise<EntregaPedidoUserTaskFormContext> {
    return new Promise<EntregaPedidoUserTaskFormContext>((resolve, reject) => {
      axios
        .get(`${baseApiUrl}/${taskId}/claim`)
        .then(res => {
          resolve(res.data);
        })
        .catch(err => {
          reject(err);
        });
    });
  }

  public complete(entregaPedidoUserTaskFormContext: EntregaPedidoUserTaskFormContext): Promise<any> {
    return new Promise<any>((resolve, reject) => {
      axios
        .post(`${baseApiUrl}/complete`, entregaPedidoUserTaskFormContext)
        .then(res => {
          resolve(res);
        })
        .catch(err => {
          reject(err);
        });
    });
  }
}
