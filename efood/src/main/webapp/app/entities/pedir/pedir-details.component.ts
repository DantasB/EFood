import { Component, Vue, Inject } from 'vue-property-decorator';

import { IPedir } from '@/shared/model/pedir.model';
import PedirService from './pedir.service';

@Component
export default class PedirDetails extends Vue {
  @Inject('pedirService') private pedirService: () => PedirService;
  public pedir: IPedir = {};

  beforeRouteEnter(to, from, next) {
    next(vm => {
      if (to.params.pedirId) {
        vm.retrievePedir(to.params.pedirId);
      }
    });
  }

  public retrievePedir(pedirId) {
    this.pedirService()
      .find(pedirId)
      .then(res => {
        this.pedir = res;
      });
  }

  public previousState() {
    this.$router.go(-1);
  }
}
