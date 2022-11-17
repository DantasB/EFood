/* tslint:disable max-line-length */
import axios from 'axios';
import sinon from 'sinon';

import PedirService from '@/entities/pedir/pedir.service';
import { Pedir } from '@/shared/model/pedir.model';

const error = {
  response: {
    status: null,
    data: {
      type: null,
    },
  },
};

const axiosStub = {
  get: sinon.stub(axios, 'get'),
  post: sinon.stub(axios, 'post'),
  put: sinon.stub(axios, 'put'),
  patch: sinon.stub(axios, 'patch'),
  delete: sinon.stub(axios, 'delete'),
};

describe('Service Tests', () => {
  describe('Pedir Service', () => {
    let service: PedirService;
    let elemDefault;

    beforeEach(() => {
      service = new PedirService();
      elemDefault = new Pedir(0, 'AAAAAAA', 'AAAAAAA', 0, 'AAAAAAA', 0, 'AAAAAAA', 'AAAAAAA', 'AAAAAAA', 'AAAAAAA', 'AAAAAAA', 'AAAAAAA');
    });

    describe('Service methods', () => {
      it('should find an element', async () => {
        const returnedFromService = Object.assign({}, elemDefault);
        axiosStub.get.resolves({ data: returnedFromService });

        return service.find(123).then(res => {
          expect(res).toMatchObject(elemDefault);
        });
      });

      it('should not find an element', async () => {
        axiosStub.get.rejects(error);
        return service
          .find(123)
          .then()
          .catch(err => {
            expect(err).toMatchObject(error);
          });
      });

      it('should return a list of Pedir', async () => {
        const returnedFromService = Object.assign(
          {
            nomeUsuario: 'BBBBBB',
            enderecoUsuario: 'BBBBBB',
            telefoneUsuario: 1,
            nomeentregador: 'BBBBBB',
            telefonerestaurante: 1,
            emailrestaurante: 'BBBBBB',
            ruarestaurante: 'BBBBBB',
            ceprestaurante: 'BBBBBB',
            idPedido: 'BBBBBB',
            horaPedido: 'BBBBBB',
            custoPedido: 'BBBBBB',
          },
          elemDefault
        );
        const expected = Object.assign({}, returnedFromService);
        axiosStub.get.resolves([returnedFromService]);
        return service.retrieve().then(res => {
          expect(res).toContainEqual(expected);
        });
      });

      it('should not return a list of Pedir', async () => {
        axiosStub.get.rejects(error);

        return service
          .retrieve()
          .then()
          .catch(err => {
            expect(err).toMatchObject(error);
          });
      });
    });
  });
});
