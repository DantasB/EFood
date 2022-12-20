/* tslint:disable max-line-length */
import { shallowMount, createLocalVue, Wrapper } from '@vue/test-utils';
import sinon, { SinonStubbedInstance } from 'sinon';
import VueRouter from 'vue-router';

import * as config from '@/shared/config/config';
import PedirDetailComponent from '@/entities/pedir/pedir-details.vue';
import PedirClass from '@/entities/pedir/pedir-details.component';
import PedirService from '@/entities/pedir/pedir.service';
import router from '@/router';

const localVue = createLocalVue();
localVue.use(VueRouter);

config.initVueApp(localVue);
const i18n = config.initI18N(localVue);
const store = config.initVueXStore(localVue);
localVue.component('font-awesome-icon', {});
localVue.component('router-link', {});

describe('Component Tests', () => {
  describe('Pedir Management Detail Component', () => {
    let wrapper: Wrapper<PedirClass>;
    let comp: PedirClass;
    let pedirServiceStub: SinonStubbedInstance<PedirService>;

    beforeEach(() => {
      pedirServiceStub = sinon.createStubInstance<PedirService>(PedirService);

      wrapper = shallowMount<PedirClass>(PedirDetailComponent, {
        store,
        i18n,
        localVue,
        router,
        provide: { pedirService: () => pedirServiceStub },
      });
      comp = wrapper.vm;
    });

    describe('OnInit', () => {
      it('Should call load all on init', async () => {
        // GIVEN
        const foundPedir = { id: 123 };
        pedirServiceStub.find.resolves(foundPedir);

        // WHEN
        comp.retrievePedir(123);
        await comp.$nextTick();

        // THEN
        expect(comp.pedir).toBe(foundPedir);
      });
    });

    describe('Before route enter', () => {
      it('Should retrieve data', async () => {
        // GIVEN
        const foundPedir = { id: 123 };
        pedirServiceStub.find.resolves(foundPedir);

        // WHEN
        comp.beforeRouteEnter({ params: { pedirId: 123 } }, null, cb => cb(comp));
        await comp.$nextTick();

        // THEN
        expect(comp.pedir).toBe(foundPedir);
      });
    });

    describe('Previous state', () => {
      it('Should go previous state', async () => {
        comp.previousState();
        await comp.$nextTick();

        expect(comp.$router.currentRoute.fullPath).toContain('/');
      });
    });
  });
});
