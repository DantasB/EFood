import { mixins } from 'vue-class-component';

import { Component, Vue, Inject } from 'vue-property-decorator';
import Vue2Filters from 'vue2-filters';
import { IRestaurante } from '@/shared/model/restaurante.model';

import RestauranteService from './restaurante.service';

@Component({
  mixins: [Vue2Filters.mixin],
})
export default class Restaurante extends Vue {
  @Inject('restauranteService') private restauranteService: () => RestauranteService;
  private removeId: number = null;

  public restaurantes: IRestaurante[] = [];

  public isFetching = false;

  public mounted(): void {
    this.retrieveAllRestaurantes();
  }

  public clear(): void {
    this.retrieveAllRestaurantes();
  }

  public retrieveAllRestaurantes(): void {
    this.isFetching = true;

    this.restauranteService()
      .retrieve()
      .then(
        res => {
          this.restaurantes = res.data;
          this.isFetching = false;
        },
        err => {
          this.isFetching = false;
        }
      );
  }

  public handleSyncList(): void {
    this.clear();
  }

  public prepareRemove(instance: IRestaurante): void {
    this.removeId = instance.id;
    if (<any>this.$refs.removeEntity) {
      (<any>this.$refs.removeEntity).show();
    }
  }

  public removeRestaurante(): void {
    this.restauranteService()
      .delete(this.removeId)
      .then(() => {
        const message = this.$t('efoodApp.restaurante.deleted', { param: this.removeId });
        this.$bvToast.toast(message.toString(), {
          toaster: 'b-toaster-top-center',
          title: 'Info',
          variant: 'danger',
          solid: true,
          autoHideDelay: 5000,
        });
        this.removeId = null;
        this.retrieveAllRestaurantes();
        this.closeDialog();
      });
  }

  public closeDialog(): void {
    (<any>this.$refs.removeEntity).hide();
  }
}
