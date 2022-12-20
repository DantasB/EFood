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
            <span v-text="$t('efoodApp.pedir.emailUsuario')">Email Usuario</span>
          </dt>
          <dd>
            <span>{{ pedir.emailUsuario }}</span>
          </dd>
          <dt>
            <span v-text="$t('efoodApp.pedir.telefoneUsuario')">Telefone Usuario</span>
          </dt>
          <dd>
            <span>{{ pedir.telefoneUsuario }}</span>
          </dd>
          <dt>
            <span v-text="$t('efoodApp.pedir.cpfUsuario')">Cpf Usuario</span>
          </dt>
          <dd>
            <span>{{ pedir.cpfUsuario }}</span>
          </dd>
          <dt>
            <span v-text="$t('efoodApp.pedir.restaurante')">Restaurante</span>
          </dt>
          <dd>
            <div v-if="pedir.restaurante">
              <router-link :to="{ name: 'RestauranteView', params: { restauranteId: pedir.restaurante.id } }">{{
                pedir.restaurante.nomeRestaurante
              }}</router-link>
            </div>
          </dd>
          <dt>
            <span v-text="$t('efoodApp.pedir.pedido')">Pedido</span>
          </dt>
          <dd>
            <div v-if="pedir.pedido">
              <router-link :to="{ name: 'PedidoView', params: { pedidoId: pedir.pedido.id } }">{{ pedir.pedido.nomePedido }}</router-link>
            </div>
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
