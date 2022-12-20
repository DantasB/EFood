<template>
  <div class="row justify-content-center">
    <div class="col-8">
      <div v-if="restaurante">
        <h2 class="jh-entity-heading" data-cy="restauranteDetailsHeading">
          <span v-text="$t('efoodApp.restaurante.detail.title')">Restaurante</span> {{ restaurante.id }}
        </h2>
        <dl class="row jh-entity-details">
          <dt>
            <span v-text="$t('efoodApp.restaurante.telefoneRestaurante')">Telefone Restaurante</span>
          </dt>
          <dd>
            <span>{{ restaurante.telefoneRestaurante }}</span>
          </dd>
          <dt>
            <span v-text="$t('efoodApp.restaurante.emailRestaurante')">Email Restaurante</span>
          </dt>
          <dd>
            <span>{{ restaurante.emailRestaurante }}</span>
          </dd>
          <dt>
            <span v-text="$t('efoodApp.restaurante.ruaRestaurante')">Rua Restaurante</span>
          </dt>
          <dd>
            <span>{{ restaurante.ruaRestaurante }}</span>
          </dd>
          <dt>
            <span v-text="$t('efoodApp.restaurante.cepRestaurante')">Cep Restaurante</span>
          </dt>
          <dd>
            <span>{{ restaurante.cepRestaurante }}</span>
          </dd>
          <dt>
            <span v-text="$t('efoodApp.restaurante.nomeEntregador')">Nome Entregador</span>
          </dt>
          <dd>
            <span>{{ restaurante.nomeEntregador }}</span>
          </dd>
          <dt>
            <span v-text="$t('efoodApp.restaurante.cnpjRestaurante')">Cnpj Restaurante</span>
          </dt>
          <dd>
            <span>{{ restaurante.cnpjRestaurante }}</span>
          </dd>
          <dt>
            <span v-text="$t('efoodApp.restaurante.nomeRestaurante')">Nome Restaurante</span>
          </dt>
          <dd>
            <span>{{ restaurante.nomeRestaurante }}</span>
          </dd>
        </dl>
        <button type="submit" v-on:click.prevent="previousState()" class="btn btn-info" data-cy="entityDetailsBackButton">
          <font-awesome-icon icon="arrow-left"></font-awesome-icon>&nbsp;<span v-text="$t('entity.action.back')"> Back</span>
        </button>
        <router-link
          v-if="restaurante.id"
          :to="{ name: 'RestauranteEdit', params: { restauranteId: restaurante.id } }"
          custom
          v-slot="{ navigate }"
        >
          <button @click="navigate" class="btn btn-primary">
            <font-awesome-icon icon="pencil-alt"></font-awesome-icon>&nbsp;<span v-text="$t('entity.action.edit')"> Edit</span>
          </button>
        </router-link>
      </div>
    </div>
  </div>
</template>

<script lang="ts" src="./restaurante-details.component.ts"></script>
