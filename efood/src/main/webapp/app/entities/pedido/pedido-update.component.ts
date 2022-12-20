import { Component, Vue, Inject } from 'vue-property-decorator';

import { IPedido, Pedido } from '@/shared/model/pedido.model';
import PedidoService from './pedido.service';

const validations: any = {
  pedido: {
    nomePedido: {},
    custoPedido: {},
  },
};

@Component({
  validations,
})
export default class PedidoUpdate extends Vue {
  @Inject('pedidoService') private pedidoService: () => PedidoService;
  public pedido: IPedido = new Pedido();
  public isSaving = false;
  public currentLanguage = '';

  beforeRouteEnter(to, from, next) {
    next(vm => {
      if (to.params.pedidoId) {
        vm.retrievePedido(to.params.pedidoId);
      }
    });
  }

  created(): void {
    this.currentLanguage = this.$store.getters.currentLanguage;
    this.$store.watch(
      () => this.$store.getters.currentLanguage,
      () => {
        this.currentLanguage = this.$store.getters.currentLanguage;
      }
    );
  }

  public save(): void {
    this.isSaving = true;
    if (this.pedido.id) {
      this.pedidoService()
        .update(this.pedido)
        .then(param => {
          this.isSaving = false;
          this.$router.go(-1);
          const message = this.$t('efoodApp.pedido.updated', { param: param.id });
          return this.$root.$bvToast.toast(message.toString(), {
            toaster: 'b-toaster-top-center',
            title: 'Info',
            variant: 'info',
            solid: true,
            autoHideDelay: 5000,
          });
        });
    } else {
      this.pedidoService()
        .create(this.pedido)
        .then(param => {
          this.isSaving = false;
          this.$router.go(-1);
          const message = this.$t('efoodApp.pedido.created', { param: param.id });
          this.$root.$bvToast.toast(message.toString(), {
            toaster: 'b-toaster-top-center',
            title: 'Success',
            variant: 'success',
            solid: true,
            autoHideDelay: 5000,
          });
        });
    }
  }

  public retrievePedido(pedidoId): void {
    this.pedidoService()
      .find(pedidoId)
      .then(res => {
        this.pedido = res;
      });
  }

  public previousState(): void {
    this.$router.go(-1);
  }

  public initRelationships(): void {}
}
