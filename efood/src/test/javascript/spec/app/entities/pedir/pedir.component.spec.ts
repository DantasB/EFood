/* tslint:disable max-line-length */
import { shallowMount, createLocalVue, Wrapper } from '@vue/test-utils';
import sinon, { SinonStubbedInstance } from 'sinon';

import * as config from '@/shared/config/config';
import PedirComponent from '@/entities/pedir/pedir.vue';
import PedirClass from '@/entities/pedir/pedir.component';
import PedirService from '@/entities/pedir/pedir.service';

const localVue = createLocalVue();

config.initVueApp(localVue);
const i18n = config.initI18N(localVue);
const store = config.initVueXStore(localVue);
localVue.component('font-awesome-icon', {});
localVue.component('b-badge', {});
localVue.directive('b-modal', {});
localVue.component('b-button', {});
localVue.component('router-link', {});

const bModalStub = {
  render: () => {},
  methods: {
    hide: () => {},
    show: () => {},
  },
};

describe('Component Tests', () => {
  describe('Pedir Management Component', () => {
    let wrapper: Wrapper<PedirClass>;
    let comp: PedirClass;
    let pedirServiceStub: SinonStubbedInstance<PedirService>;

    beforeEach(() => {
      pedirServiceStub = sinon.createStubInstance<PedirService>(PedirService);
      pedirServiceStub.retrieve.resolves({ headers: {} });

      wrapper = shallowMount<PedirClass>(PedirComponent, {
        store,
        i18n,
        localVue,
        stubs: { bModal: bModalStub as any },
        provide: {
          pedirService: () => pedirServiceStub,
        },
      });
      comp = wrapper.vm;
    });

    it('Should call load all on init', async () => {
      // GIVEN
      pedirServiceStub.retrieve.resolves({ headers: {}, data: [{ id: 123 }] });

      // WHEN
      comp.retrieveAllPedirs();
      await comp.$nextTick();

      // THEN
      expect(pedirServiceStub.retrieve.called).toBeTruthy();
      expect(comp.pedirs[0]).toEqual(jasmine.objectContaining({ id: 123 }));
    });
  });
});
