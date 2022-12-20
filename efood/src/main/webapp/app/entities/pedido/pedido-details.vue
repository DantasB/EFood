<template>
  <div class="row justify-content-center">
    <div class="col-8">
      <div v-if="pedido">
        <h2 class="jh-entity-heading" data-cy="pedidoDetailsHeading">
          <span v-text="$t('efoodApp.pedido.detail.title')">Pedido</span> {{ pedido.id }}
        </h2>
        <dl class="row jh-entity-details">
          <dt>
            <span v-text="$t('efoodApp.pedido.nomePedido')">Nome Pedido</span>
          </dt>
          <dd>
            <span>{{ pedido.nomePedido }}</span>
          </dd>
          <dt>
            <span v-text="$t('efoodApp.pedido.custoPedido')">Custo Pedido</span>
          </dt>
          <dd>
            <span>{{ pedido.custoPedido }}</span>
          </dd>
        </dl>
        <button type="submit" v-on:click.prevent="previousState()" class="btn btn-info" data-cy="entityDetailsBackButton">
          <font-awesome-icon icon="arrow-left"></font-awesome-icon>&nbsp;<span v-text="$t('entity.action.back')"> Back</span>
        </button>
        <router-link v-if="pedido.id" :to="{ name: 'PedidoEdit', params: { pedidoId: pedido.id } }" custom v-slot="{ navigate }">
          <button @click="navigate" class="btn btn-primary">
            <font-awesome-icon icon="pencil-alt"></font-awesome-icon>&nbsp;<span v-text="$t('entity.action.edit')"> Edit</span>
          </button>
        </router-link>
      </div>
    </div>
  </div>
</template>

<script lang="ts" src="./pedido-details.component.ts"></script>
