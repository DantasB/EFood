import { Component, Vue, Inject } from 'vue-property-decorator';

import RestauranteService from '@/entities/restaurante/restaurante.service';
import { IRestaurante } from '@/shared/model/restaurante.model';

import PedidoService from '@/entities/pedido/pedido.service';
import { IPedido } from '@/shared/model/pedido.model';

import EntregaPedidoUserTaskFormService from './entrega-pedido-user-task-form.service';
import { EntregaPedidoUserTaskFormContext } from './entrega-pedido-user-task-form.model';

const validations: any = {
  taskContext: {
    pedirProcess: {
      pedir: {},
    },
  },
};

@Component({
  validations,
})
export default class EntregaPedidoUserTaskFormExecuteComponent extends Vue {
  private entregaPedidoUserTaskFormService: EntregaPedidoUserTaskFormService = new EntregaPedidoUserTaskFormService();
  private taskContext: EntregaPedidoUserTaskFormContext = {};

  @Inject('restauranteService') private restauranteService: () => RestauranteService;

  public restaurantes: IRestaurante[] = [];

  @Inject('pedidoService') private pedidoService: () => PedidoService;

  public pedidos: IPedido[] = [];
  public isSaving = false;

  beforeRouteEnter(to, from, next) {
    next(vm => {
      if (to.params.taskInstanceId) {
        vm.claimTaskInstance(to.params.taskInstanceId);
      }
      vm.initRelationships();
    });
  }

  public claimTaskInstance(taskInstanceId) {
    this.entregaPedidoUserTaskFormService.claim(taskInstanceId).then(res => {
      this.taskContext = res;
    });
  }

  public previousState() {
    this.$router.go(-1);
  }

  public complete() {
    this.entregaPedidoUserTaskFormService.complete(this.taskContext).then(res => {
      this.$router.go(-1);
    });
  }

  public initRelationships(): void {
    this.restauranteService()
      .retrieve()
      .then(res => {
        this.restaurantes = res.data;
      });
    this.pedidoService()
      .retrieve()
      .then(res => {
        this.pedidos = res.data;
      });
  }
}
