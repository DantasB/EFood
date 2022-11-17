import { mixins } from 'vue-class-component';

import { Component, Vue, Inject } from 'vue-property-decorator';
import Vue2Filters from 'vue2-filters';
import { IPedir } from '@/shared/model/pedir.model';

import PedirService from './pedir.service';

@Component({
  mixins: [Vue2Filters.mixin],
})
export default class Pedir extends Vue {
  @Inject('pedirService') private pedirService: () => PedirService;
  private removeId: number = null;

  public pedirs: IPedir[] = [];

  public isFetching = false;

  public mounted(): void {
    this.retrieveAllPedirs();
  }

  public clear(): void {
    this.retrieveAllPedirs();
  }

  public retrieveAllPedirs(): void {
    this.isFetching = true;

    this.pedirService()
      .retrieve()
      .then(
        res => {
          this.pedirs = res.data;
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

  public closeDialog(): void {
    (<any>this.$refs.removeEntity).hide();
  }
}
