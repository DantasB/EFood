import { Authority } from '@/shared/security/authority';
/* tslint:disable */
// prettier-ignore

// prettier-ignore
const Pedir = () => import('@/entities/pedir/pedir.vue');
// prettier-ignore
const PedirDetails = () => import('@/entities/pedir/pedir-details.vue');
// prettier-ignore
const Usuario = () => import('@/entities/usuario/usuario.vue');
// prettier-ignore
const UsuarioUpdate = () => import('@/entities/usuario/usuario-update.vue');
// prettier-ignore
const UsuarioDetails = () => import('@/entities/usuario/usuario-details.vue');
// prettier-ignore
const Restaurante = () => import('@/entities/restaurante/restaurante.vue');
// prettier-ignore
const RestauranteUpdate = () => import('@/entities/restaurante/restaurante-update.vue');
// prettier-ignore
const RestauranteDetails = () => import('@/entities/restaurante/restaurante-details.vue');
// prettier-ignore
const Pedido = () => import('@/entities/pedido/pedido.vue');
// prettier-ignore
const PedidoUpdate = () => import('@/entities/pedido/pedido-update.vue');
// prettier-ignore
const PedidoDetails = () => import('@/entities/pedido/pedido-details.vue');
// prettier-ignore
const PedirProcessDetails = () => import('@/entities/pedir-process/pedir-process-details.vue');
// prettier-ignore
const PedirProcessList = () => import('@/entities/pedir-process/pedir-process-list.vue');
// prettier-ignore
const PedirStartFormInit = () => import('@/entities/pedir-process/pedir-start-form-init.vue');
// prettier-ignore
const PedirProcess_EntregaPedidoUserTaskFormDetails = () => import('@/entities/pedir-process/entrega-pedido-user-task-form/entrega-pedido-user-task-form-details.vue');
// prettier-ignore
const PedirProcess_EntregaPedidoUserTaskFormExecute = () => import('@/entities/pedir-process/entrega-pedido-user-task-form/entrega-pedido-user-task-form-execute.vue');
// jhipster-needle-add-entity-to-router-import - JHipster will import entities to the router here

export default [
  {
    path: '/pedir',
    name: 'Pedir',
    component: Pedir,
    meta: { authorities: [Authority.USER] },
  },
  {
    path: '/pedir/:pedirId/view',
    name: 'PedirView',
    component: PedirDetails,
    meta: { authorities: [Authority.USER] },
  },
  {
    path: '/usuario',
    name: 'Usuario',
    component: Usuario,
    meta: { authorities: [Authority.USER] },
  },
  {
    path: '/usuario/new',
    name: 'UsuarioCreate',
    component: UsuarioUpdate,
    meta: { authorities: [Authority.USER] },
  },
  {
    path: '/usuario/:usuarioId/edit',
    name: 'UsuarioEdit',
    component: UsuarioUpdate,
    meta: { authorities: [Authority.USER] },
  },
  {
    path: '/usuario/:usuarioId/view',
    name: 'UsuarioView',
    component: UsuarioDetails,
    meta: { authorities: [Authority.USER] },
  },
  {
    path: '/restaurante',
    name: 'Restaurante',
    component: Restaurante,
    meta: { authorities: [Authority.USER] },
  },
  {
    path: '/restaurante/new',
    name: 'RestauranteCreate',
    component: RestauranteUpdate,
    meta: { authorities: [Authority.USER] },
  },
  {
    path: '/restaurante/:restauranteId/edit',
    name: 'RestauranteEdit',
    component: RestauranteUpdate,
    meta: { authorities: [Authority.USER] },
  },
  {
    path: '/restaurante/:restauranteId/view',
    name: 'RestauranteView',
    component: RestauranteDetails,
    meta: { authorities: [Authority.USER] },
  },
  {
    path: '/pedido',
    name: 'Pedido',
    component: Pedido,
    meta: { authorities: [Authority.USER] },
  },
  {
    path: '/pedido/new',
    name: 'PedidoCreate',
    component: PedidoUpdate,
    meta: { authorities: [Authority.USER] },
  },
  {
    path: '/pedido/:pedidoId/edit',
    name: 'PedidoEdit',
    component: PedidoUpdate,
    meta: { authorities: [Authority.USER] },
  },
  {
    path: '/pedido/:pedidoId/view',
    name: 'PedidoView',
    component: PedidoDetails,
    meta: { authorities: [Authority.USER] },
  },
  {
    path: '/process-definition/PedirProcess/instance/:processInstanceId/view',
    name: 'PedirProcessView',
    component: PedirProcessDetails,
    meta: { authorities: [Authority.USER] },
  },
  {
    path: '/process-definition/PedirProcess/instances',
    name: 'PedirProcessList',
    component: PedirProcessList,
    meta: { authorities: [Authority.USER] },
  },
  {
    path: '/process-definition/PedirProcess/init',
    name: 'PedirStartFormInit',
    component: PedirStartFormInit,
    meta: { authorities: [Authority.USER] },
  },
  {
    path: '/process-definition/PedirProcess/task/EntregaPedidoUserTaskForm/:taskInstanceId/view',
    name: 'PedirProcess_EntregaPedidoUserTaskFormDetails',
    component: PedirProcess_EntregaPedidoUserTaskFormDetails,
    meta: { authorities: [Authority.USER] },
  },
  {
    path: '/process-definition/PedirProcess/task/EntregaPedidoUserTaskForm/:taskInstanceId/execute',
    name: 'PedirProcess_EntregaPedidoUserTaskFormExecute',
    component: PedirProcess_EntregaPedidoUserTaskFormExecute,
    meta: { authorities: [Authority.USER] },
  },
  // jhipster-needle-add-entity-to-router - JHipster will add entities to the router here
];
