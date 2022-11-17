import { Component, Vue, Inject } from 'vue-property-decorator';

import { IPedirProcess } from '@/shared/model/pedir-process.model';
import PedirProcessService from './pedir-process.service';

@Component
export default class PedirProcessDetailsComponent extends Vue {
  @Inject('pedirProcessService') private pedirProcessService: () => PedirProcessService;
  public pedirProcess: IPedirProcess = {};

  public isFetching: boolean = false;

  beforeRouteEnter(to, from, next) {
    next(vm => {
      if (to.params.processInstanceId) {
        vm.retrievePedirProcess(to.params.processInstanceId);
      }
    });
  }

  public retrievePedirProcess(pedirProcessId) {
    this.isFetching = true;
    this.pedirProcessService()
      .find(pedirProcessId)
      .then(
        res => {
          this.pedirProcess = res;
          this.isFetching = false;
        },
        err => {
          this.isFetching = false;
        }
      );
  }

  public previousState() {
    this.$router.go(-1);
  }
}
