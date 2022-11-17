import { Authority } from '@/shared/security/authority';
/* tslint:disable */
// prettier-ignore

// prettier-ignore
const Pedir = () => import('@/entities/pedir/pedir.vue');
// prettier-ignore
const PedirDetails = () => import('@/entities/pedir/pedir-details.vue');
// prettier-ignore
const PedirProcessDetails = () => import('@/entities/pedir-process/pedir-process-details.vue');
// prettier-ignore
const PedirProcessList = () => import('@/entities/pedir-process/pedir-process-list.vue');
// prettier-ignore
const PedirStartFormInit = () => import('@/entities/pedir-process/pedir-start-form-init.vue');
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
  // jhipster-needle-add-entity-to-router - JHipster will add entities to the router here
];
