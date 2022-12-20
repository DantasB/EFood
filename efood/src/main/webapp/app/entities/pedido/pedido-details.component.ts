import { Component, Vue, Inject } from 'vue-property-decorator';

import { IPedido } from '@/shared/model/pedido.model';
import PedidoService from './pedido.service';

@Component
export default class PedidoDetails extends Vue {
  @Inject('pedidoService') private pedidoService: () => PedidoService;
  public pedido: IPedido = {};

  beforeRouteEnter(to, from, next) {
    next(vm => {
      if (to.params.pedidoId) {
        vm.retrievePedido(to.params.pedidoId);
      }
    });
  }

  public retrievePedido(pedidoId) {
    this.pedidoService()
      .find(pedidoId)
      .then(res => {
        this.pedido = res;
      });
  }

  public previousState() {
    this.$router.go(-1);
  }
}
