<template>
  <div class="row justify-content-center">
    <div class="col-8">
      <form name="editForm" role="form" novalidate v-on:submit.prevent="save()">
        <h2
          id="efoodApp.pedido.home.createOrEditLabel"
          data-cy="PedidoCreateUpdateHeading"
          v-text="$t('efoodApp.pedido.home.createOrEditLabel')"
        >
          Create or edit a Pedido
        </h2>
        <div>
          <div class="form-group" v-if="pedido.id">
            <label for="id" v-text="$t('global.field.id')">ID</label>
            <input type="text" class="form-control" id="id" name="id" v-model="pedido.id" readonly />
          </div>
          <div class="form-group">
            <label class="form-control-label" v-text="$t('efoodApp.pedido.nomePedido')" for="pedido-nomePedido">Nome Pedido</label>
            <input
              type="text"
              class="form-control"
              name="nomePedido"
              id="pedido-nomePedido"
              data-cy="nomePedido"
              :class="{ valid: !$v.pedido.nomePedido.$invalid, invalid: $v.pedido.nomePedido.$invalid }"
              v-model="$v.pedido.nomePedido.$model"
            />
          </div>
          <div class="form-group">
            <label class="form-control-label" v-text="$t('efoodApp.pedido.custoPedido')" for="pedido-custoPedido">Custo Pedido</label>
            <input
              type="number"
              class="form-control"
              name="custoPedido"
              id="pedido-custoPedido"
              data-cy="custoPedido"
              :class="{ valid: !$v.pedido.custoPedido.$invalid, invalid: $v.pedido.custoPedido.$invalid }"
              v-model.number="$v.pedido.custoPedido.$model"
            />
          </div>
        </div>
        <div>
          <button type="button" id="cancel-save" class="btn btn-secondary" v-on:click="previousState()">
            <font-awesome-icon icon="ban"></font-awesome-icon>&nbsp;<span v-text="$t('entity.action.cancel')">Cancel</span>
          </button>
          <button
            type="submit"
            id="save-entity"
            data-cy="entityCreateSaveButton"
            :disabled="$v.pedido.$invalid || isSaving"
            class="btn btn-primary"
          >
            <font-awesome-icon icon="save"></font-awesome-icon>&nbsp;<span v-text="$t('entity.action.save')">Save</span>
          </button>
        </div>
      </form>
    </div>
  </div>
</template>
<script lang="ts" src="./pedido-update.component.ts"></script>
