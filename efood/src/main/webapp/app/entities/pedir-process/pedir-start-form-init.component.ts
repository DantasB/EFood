import { Component, Vue, Inject } from 'vue-property-decorator';

import { IPedirProcess, PedirProcess } from '@/shared/model/pedir-process.model';

import { ProcessInstance, ProcessDefinitionService } from 'akip-vue-community';

import { Pedir } from '@/shared/model/pedir.model';
import PedirProcessService from './pedir-process.service';

const validations: any = {
  pedirProcess: {
    pedir: {
      nomeUsuario: {},
      enderecoUsuario: {},
      telefoneUsuario: {},
      cpfUsuario: {},
      emailUsuario: {},
    },
  },
};

@Component({
  validations,
})
export default class PedirStartFormInitComponent extends Vue {
  @Inject('pedirProcessService') private pedirProcessService: () => PedirProcessService;

  private processDefinitionService: ProcessDefinitionService = new ProcessDefinitionService();

  public bpmnProcessDefinitionId: string = 'PedirProcess';
  public pedirProcess: IPedirProcess = new PedirProcess();

  public isSaving = false;
  public currentLanguage = '';

  beforeRouteEnter(to, from, next) {
    next(vm => {
      vm.initPedirStartForm();
      vm.initRelationships();
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

    this.pedirProcessService()
      .create(this.pedirProcess)
      .then(param => {
        this.isSaving = false;
        this.$router.go(-1);
        const message = this.$t('efoodApp.pedirStartForm.created', { param: param.id });
        this.$root.$bvToast.toast(message.toString(), {
          toaster: 'b-toaster-top-center',
          title: 'Success',
          variant: 'success',
          solid: true,
          autoHideDelay: 5000,
        });
      });
  }

  public initPedirStartForm(): void {
    this.pedirProcess.pedir = new Pedir();
  }

  public previousState(): void {
    this.$router.go(-1);
  }

  public initRelationships(): void {
    this.processDefinitionService.find(this.bpmnProcessDefinitionId).then(res => {
      this.pedirProcess.processInstance = new ProcessInstance();
      this.pedirProcess.processInstance.processDefinition = res;
    });
  }
}
