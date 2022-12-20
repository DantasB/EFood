<template>
  <div class="row justify-content-center">
    <div class="col-10">
      <h2 id="page-heading" data-cy="TaskInstanceHeading">
        <span v-text="$t('efoodApp.taskInstance.details.title')" id="task-instance-heading">Task Details</span>
      </h2>
      <div v-if="taskContext.taskInstance">
        <akip-show-task-instance :taskInstance="taskContext.taskInstance">
          <template v-slot:body>
            <hr />
            <div class="form-group">
              <label
                class="form-control-label"
                v-text="$t('efoodApp.entregaPedidoUserTaskForm.restaurante')"
                for="entrega-pedido-user-task-form-restaurante"
                >Restaurante</label
              >
              <input
                v-if="taskContext.pedirProcess.pedir.restaurante"
                readonly
                type="text"
                class="form-control"
                name="restaurante"
                id="pedir-restaurante"
                data-cy="restaurante"
                :value="taskContext.pedirProcess.pedir.restaurante.nomeRestaurante"
              />
              <input
                v-else
                readonly
                type="text"
                class="form-control"
                name="restaurante"
                id="pedir-restaurante"
                data-cy="restaurante"
                value=""
              />
            </div>
            <div class="form-group">
              <label
                class="form-control-label"
                v-text="$t('efoodApp.entregaPedidoUserTaskForm.pedido')"
                for="entrega-pedido-user-task-form-pedido"
                >Pedido</label
              >
              <input
                v-if="taskContext.pedirProcess.pedir.pedido"
                readonly
                type="text"
                class="form-control"
                name="pedido"
                id="pedir-pedido"
                data-cy="pedido"
                :value="taskContext.pedirProcess.pedir.pedido.nomePedido"
              />
              <input v-else readonly type="text" class="form-control" name="pedido" id="pedir-pedido" data-cy="pedido" value="" />
            </div>
          </template>
        </akip-show-task-instance>
        <br />
        <button type="submit" v-on:click.prevent="previousState()" class="btn btn-info" data-cy="entityDetailsBackButton">
          <font-awesome-icon icon="arrow-left"></font-awesome-icon>&nbsp;<span v-text="$t('entity.action.back')"> Back</span>
        </button>

        <router-link
          v-if="taskContext.taskInstance.status == 'NEW' || taskContext.taskInstance.status == 'ASSIGNED'"
          :to="`/process-definition/PedirProcess/task/EntregaPedidoUserTaskForm/${taskContext.taskInstance.id}/execute`"
          tag="button"
          class="btn btn-primary"
          data-cy="entityDetailsButton"
        >
          <font-awesome-icon icon="play"></font-awesome-icon>&nbsp;Execute
        </router-link>
      </div>
    </div>
  </div>
</template>

<script lang="ts" src="./entrega-pedido-user-task-form-details.component.ts"></script>
