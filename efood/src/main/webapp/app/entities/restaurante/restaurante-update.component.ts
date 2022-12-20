import { Component, Vue, Inject } from 'vue-property-decorator';

import { IRestaurante, Restaurante } from '@/shared/model/restaurante.model';
import RestauranteService from './restaurante.service';

const validations: any = {
  restaurante: {
    telefoneRestaurante: {},
    emailRestaurante: {},
    ruaRestaurante: {},
    cepRestaurante: {},
    nomeEntregador: {},
    cnpjRestaurante: {},
    nomeRestaurante: {},
  },
};

@Component({
  validations,
})
export default class RestauranteUpdate extends Vue {
  @Inject('restauranteService') private restauranteService: () => RestauranteService;
  public restaurante: IRestaurante = new Restaurante();
  public isSaving = false;
  public currentLanguage = '';

  beforeRouteEnter(to, from, next) {
    next(vm => {
      if (to.params.restauranteId) {
        vm.retrieveRestaurante(to.params.restauranteId);
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
    if (this.restaurante.id) {
      this.restauranteService()
        .update(this.restaurante)
        .then(param => {
          this.isSaving = false;
          this.$router.go(-1);
          const message = this.$t('efoodApp.restaurante.updated', { param: param.id });
          return this.$root.$bvToast.toast(message.toString(), {
            toaster: 'b-toaster-top-center',
            title: 'Info',
            variant: 'info',
            solid: true,
            autoHideDelay: 5000,
          });
        });
    } else {
      this.restauranteService()
        .create(this.restaurante)
        .then(param => {
          this.isSaving = false;
          this.$router.go(-1);
          const message = this.$t('efoodApp.restaurante.created', { param: param.id });
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

  public retrieveRestaurante(restauranteId): void {
    this.restauranteService()
      .find(restauranteId)
      .then(res => {
        this.restaurante = res;
      });
  }

  public previousState(): void {
    this.$router.go(-1);
  }

  public initRelationships(): void {}
}
