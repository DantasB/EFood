/* tslint:disable max-line-length */
import { shallowMount, createLocalVue, Wrapper } from '@vue/test-utils';
import sinon, { SinonStubbedInstance } from 'sinon';
import Router from 'vue-router';

import * as config from '@/shared/config/config';
import PedidoUpdateComponent from '@/entities/pedido/pedido-update.vue';
import PedidoClass from '@/entities/pedido/pedido-update.component';
import PedidoService from '@/entities/pedido/pedido.service';

const localVue = createLocalVue();

config.initVueApp(localVue);
const i18n = config.initI18N(localVue);
const store = config.initVueXStore(localVue);
const router = new Router();
localVue.use(Router);
localVue.component('font-awesome-icon', {});
localVue.component('b-input-group', {});
localVue.component('b-input-group-prepend', {});
localVue.component('b-form-datepicker', {});
localVue.component('b-form-input', {});

describe('Component Tests', () => {
  describe('Pedido Management Update Component', () => {
    let wrapper: Wrapper<PedidoClass>;
    let comp: PedidoClass;
    let pedidoServiceStub: SinonStubbedInstance<PedidoService>;

    beforeEach(() => {
      pedidoServiceStub = sinon.createStubInstance<PedidoService>(PedidoService);

      wrapper = shallowMount<PedidoClass>(PedidoUpdateComponent, {
        store,
        i18n,
        localVue,
        router,
        provide: {
          pedidoService: () => pedidoServiceStub,
        },
      });
      comp = wrapper.vm;
    });

    describe('save', () => {
      it('Should call update service on save for existing entity', async () => {
        // GIVEN
        const entity = { id: 123 };
        comp.pedido = entity;
        pedidoServiceStub.update.resolves(entity);

        // WHEN
        comp.save();
        await comp.$nextTick();

        // THEN
        expect(pedidoServiceStub.update.calledWith(entity)).toBeTruthy();
        expect(comp.isSaving).toEqual(false);
      });

      it('Should call create service on save for new entity', async () => {
        // GIVEN
        const entity = {};
        comp.pedido = entity;
        pedidoServiceStub.create.resolves(entity);

        // WHEN
        comp.save();
        await comp.$nextTick();

        // THEN
        expect(pedidoServiceStub.create.calledWith(entity)).toBeTruthy();
        expect(comp.isSaving).toEqual(false);
      });
    });

    describe('Before route enter', () => {
      it('Should retrieve data', async () => {
        // GIVEN
        const foundPedido = { id: 123 };
        pedidoServiceStub.find.resolves(foundPedido);
        pedidoServiceStub.retrieve.resolves([foundPedido]);

        // WHEN
        comp.beforeRouteEnter({ params: { pedidoId: 123 } }, null, cb => cb(comp));
        await comp.$nextTick();

        // THEN
        expect(comp.pedido).toBe(foundPedido);
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
