import { Component, Vue, Inject } from 'vue-property-decorator';

import EntregaPedidoUserTaskFormService from './entrega-pedido-user-task-form.service';
import { EntregaPedidoUserTaskFormContext } from './entrega-pedido-user-task-form.model';

@Component
export default class EntregaPedidoUserTaskFormDetailsComponent extends Vue {
  private entregaPedidoUserTaskFormService: EntregaPedidoUserTaskFormService = new EntregaPedidoUserTaskFormService();
  private taskContext: EntregaPedidoUserTaskFormContext = {};

  beforeRouteEnter(to, from, next) {
    next(vm => {
      if (to.params.taskInstanceId) {
        vm.retrieveContext(to.params.taskInstanceId);
      }
    });
  }

  public retrieveContext(taskInstanceId) {
    this.entregaPedidoUserTaskFormService.loadContext(taskInstanceId).then(res => {
      this.taskContext = res;
    });
  }

  public previousState() {
    this.$router.go(-1);
  }
}
