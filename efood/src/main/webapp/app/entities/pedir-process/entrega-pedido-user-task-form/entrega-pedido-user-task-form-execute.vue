<template>
  <div class="row justify-content-center">
    <div class="col-10">
      <div v-if="taskContext.taskInstance">
        <h2 id="page-heading" data-cy="TaskInstanceHeading">
          <span v-text="$t('efoodApp.taskInstance.execute.title')" id="task-instance-heading">Task Execution</span>
        </h2>
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
              <select
                class="form-control"
                id="entrega-pedido-user-task-form-restaurante"
                data-cy="restaurante"
                name="restaurante"
                v-model="taskContext.pedirProcess.pedir.restaurante"
              >
                <option v-bind:value="null"></option>
                <option
                  v-bind:value="
                    taskContext.pedirProcess.pedir.restaurante && restauranteOption.id === taskContext.pedirProcess.pedir.restaurante.id
                      ? taskContext.pedirProcess.pedir.restaurante
                      : restauranteOption
                  "
                  v-for="restauranteOption in restaurantes"
                  :key="restauranteOption.id"
                >
                  {{ restauranteOption.nomeRestaurante }}
                </option>
              </select>
            </div>
            <div class="form-group">
              <label
                class="form-control-label"
                v-text="$t('efoodApp.entregaPedidoUserTaskForm.pedido')"
                for="entrega-pedido-user-task-form-pedido"
                >Pedido</label
              >
              <select
                class="form-control"
                id="entrega-pedido-user-task-form-pedido"
                data-cy="pedido"
                name="pedido"
                v-model="taskContext.pedirProcess.pedir.pedido"
              >
                <option v-bind:value="null"></option>
                <option
                  v-bind:value="
                    taskContext.pedirProcess.pedir.pedido && pedidoOption.id === taskContext.pedirProcess.pedir.pedido.id
                      ? taskContext.pedirProcess.pedir.pedido
                      : pedidoOption
                  "
                  v-for="pedidoOption in pedidos"
                  :key="pedidoOption.id"
                >
                  {{ pedidoOption.nomePedido }}
                </option>
              </select>
            </div>
          </template>
        </akip-show-task-instance>
        <br />
        <button type="submit" v-on:click.prevent="previousState()" class="btn btn-info" data-cy="entityDetailsBackButton">
          <font-awesome-icon icon="arrow-left"></font-awesome-icon>&nbsp;<span v-text="$t('entity.action.back')"> Back</span>
        </button>
        <button type="submit" v-on:click.prevent="complete()" class="btn btn-success" data-cy="complete">
          <font-awesome-icon icon="check-circle"></font-awesome-icon>&nbsp;Complete
        </button>
      </div>
    </div>
  </div>
</template>

<script lang="ts" src="./entrega-pedido-user-task-form-execute.component.ts"></script>
