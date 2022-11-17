import { Component, Vue, Inject } from 'vue-property-decorator';
import { IPedirProcess } from '@/shared/model/pedir-process.model';

import { ProcessDefinition, ProcessDefinitionService } from 'akip-vue-community';

import PedirProcessService from './pedir-process.service';

@Component
export default class PedirProcessListComponent extends Vue {
  @Inject('pedirProcessService') private pedirProcessService: () => PedirProcessService;

  private processDefinitionService: ProcessDefinitionService = new ProcessDefinitionService();

  public bpmnProcessDefinitionId: string = 'PedirProcess';
  public processDefinition: ProcessDefinition = new ProcessDefinition();
  public pedirProcessList: IPedirProcess[] = [];

  public isFetchingProcessDefinition = false;
  public isFetchingProcessInstances = false;

  public mounted(): void {
    this.init();
  }

  public init(): void {
    this.retrieveProcessDefinition();
    this.retrieveProcessInstances();
  }

  public retrieveProcessDefinition() {
    this.isFetchingProcessDefinition = true;
    this.processDefinitionService.find(this.bpmnProcessDefinitionId).then(
      res => {
        this.processDefinition = res;
        this.isFetchingProcessDefinition = false;
      },
      err => {
        this.isFetchingProcessDefinition = false;
      }
    );
  }

  public retrieveProcessInstances(): void {
    this.isFetchingProcessInstances = true;
    this.pedirProcessService()
      .retrieve()
      .then(
        res => {
          this.pedirProcessList = res.data;
          this.isFetchingProcessInstances = false;
        },
        err => {
          this.isFetchingProcessInstances = false;
        }
      );
  }

  get isFetching(): boolean {
    return this.isFetchingProcessDefinition && this.isFetchingProcessInstances;
  }

  public handleSyncList(): void {
    this.retrieveProcessInstances();
  }

  public previousState(): void {
    this.$router.go(-1);
  }
}
