<template>
  <div class="row justify-content-center">
    <div class="col-8">
      <div v-if="pedir">
        <h2 class="jh-entity-heading" data-cy="pedirDetailsHeading">
          <span v-text="$t('efoodApp.pedir.detail.title')">Pedir</span> {{ pedir.id }}
        </h2>
        <dl class="row jh-entity-details">
          <dt>
            <span v-text="$t('efoodApp.pedir.nomeUsuario')">Nome Usuario</span>
          </dt>
          <dd>
            <span>{{ pedir.nomeUsuario }}</span>
          </dd>
          <dt>
            <span v-text="$t('efoodApp.pedir.enderecoUsuario')">Endereco Usuario</span>
          </dt>
          <dd>
            <span>{{ pedir.enderecoUsuario }}</span>
          </dd>
          <dt>
            <span v-text="$t('efoodApp.pedir.telefoneUsuario')">Telefone Usuario</span>
          </dt>
          <dd>
            <span>{{ pedir.telefoneUsuario }}</span>
          </dd>
          <dt>
            <span v-text="$t('efoodApp.pedir.nomeentregador')">Nomeentregador</span>
          </dt>
          <dd>
            <span>{{ pedir.nomeentregador }}</span>
          </dd>
          <dt>
            <span v-text="$t('efoodApp.pedir.telefonerestaurante')">Telefonerestaurante</span>
          </dt>
          <dd>
            <span>{{ pedir.telefonerestaurante }}</span>
          </dd>
          <dt>
            <span v-text="$t('efoodApp.pedir.emailrestaurante')">Emailrestaurante</span>
          </dt>
          <dd>
            <span>{{ pedir.emailrestaurante }}</span>
          </dd>
          <dt>
            <span v-text="$t('efoodApp.pedir.ruarestaurante')">Ruarestaurante</span>
          </dt>
          <dd>
            <span>{{ pedir.ruarestaurante }}</span>
          </dd>
          <dt>
            <span v-text="$t('efoodApp.pedir.ceprestaurante')">Ceprestaurante</span>
          </dt>
          <dd>
            <span>{{ pedir.ceprestaurante }}</span>
          </dd>
          <dt>
            <span v-text="$t('efoodApp.pedir.idPedido')">Id Pedido</span>
          </dt>
          <dd>
            <span>{{ pedir.idPedido }}</span>
          </dd>
          <dt>
            <span v-text="$t('efoodApp.pedir.horaPedido')">Hora Pedido</span>
          </dt>
          <dd>
            <span>{{ pedir.horaPedido }}</span>
          </dd>
          <dt>
            <span v-text="$t('efoodApp.pedir.custoPedido')">Custo Pedido</span>
          </dt>
          <dd>
            <span>{{ pedir.custoPedido }}</span>
          </dd>
        </dl>
        <button type="submit" v-on:click.prevent="previousState()" class="btn btn-info" data-cy="entityDetailsBackButton">
          <font-awesome-icon icon="arrow-left"></font-awesome-icon>&nbsp;<span v-text="$t('entity.action.back')"> Back</span>
        </button>
      </div>
    </div>
  </div>
</template>

<script lang="ts" src="./pedir-details.component.ts"></script>
