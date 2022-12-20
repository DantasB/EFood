<template>
  <div>
    <h2 id="page-heading" data-cy="RestauranteHeading">
      <span v-text="$t('efoodApp.restaurante.home.title')" id="restaurante-heading">Restaurantes</span>
      <div class="d-flex justify-content-end">
        <button class="btn btn-info mr-2" v-on:click="handleSyncList" :disabled="isFetching">
          <font-awesome-icon icon="sync" :spin="isFetching"></font-awesome-icon>
          <span v-text="$t('efoodApp.restaurante.home.refreshListLabel')">Refresh List</span>
        </button>
        <router-link :to="{ name: 'RestauranteCreate' }" custom v-slot="{ navigate }">
          <button
            @click="navigate"
            id="jh-create-entity"
            data-cy="entityCreateButton"
            class="btn btn-primary jh-create-entity create-restaurante"
          >
            <font-awesome-icon icon="plus"></font-awesome-icon>
            <span v-text="$t('efoodApp.restaurante.home.createLabel')"> Create a new Restaurante </span>
          </button>
        </router-link>
      </div>
    </h2>
    <br />
    <div class="alert alert-warning" v-if="!isFetching && restaurantes && restaurantes.length === 0">
      <span v-text="$t('efoodApp.restaurante.home.notFound')">No restaurantes found</span>
    </div>
    <div class="table-responsive" v-if="restaurantes && restaurantes.length > 0">
      <table class="table table-striped" aria-describedby="restaurantes">
        <thead>
          <tr>
            <th scope="row"><span v-text="$t('global.field.id')">ID</span></th>
            <th scope="row"><span v-text="$t('efoodApp.restaurante.telefoneRestaurante')">Telefone Restaurante</span></th>
            <th scope="row"><span v-text="$t('efoodApp.restaurante.emailRestaurante')">Email Restaurante</span></th>
            <th scope="row"><span v-text="$t('efoodApp.restaurante.ruaRestaurante')">Rua Restaurante</span></th>
            <th scope="row"><span v-text="$t('efoodApp.restaurante.cepRestaurante')">Cep Restaurante</span></th>
            <th scope="row"><span v-text="$t('efoodApp.restaurante.nomeEntregador')">Nome Entregador</span></th>
            <th scope="row"><span v-text="$t('efoodApp.restaurante.cnpjRestaurante')">Cnpj Restaurante</span></th>
            <th scope="row"><span v-text="$t('efoodApp.restaurante.nomeRestaurante')">Nome Restaurante</span></th>
            <th scope="row"></th>
          </tr>
        </thead>
        <tbody>
          <tr v-for="restaurante in restaurantes" :key="restaurante.id" data-cy="entityTable">
            <td>
              <router-link :to="{ name: 'RestauranteView', params: { restauranteId: restaurante.id } }">{{ restaurante.id }}</router-link>
            </td>
            <td>{{ restaurante.telefoneRestaurante }}</td>
            <td>{{ restaurante.emailRestaurante }}</td>
            <td>{{ restaurante.ruaRestaurante }}</td>
            <td>{{ restaurante.cepRestaurante }}</td>
            <td>{{ restaurante.nomeEntregador }}</td>
            <td>{{ restaurante.cnpjRestaurante }}</td>
            <td>{{ restaurante.nomeRestaurante }}</td>
            <td class="text-right">
              <div class="btn-group">
                <router-link :to="{ name: 'RestauranteView', params: { restauranteId: restaurante.id } }" custom v-slot="{ navigate }">
                  <button @click="navigate" class="btn btn-info btn-sm details" data-cy="entityDetailsButton">
                    <font-awesome-icon icon="eye"></font-awesome-icon>
                    <span class="d-none d-md-inline" v-text="$t('entity.action.view')">View</span>
                  </button>
                </router-link>
                <router-link :to="{ name: 'RestauranteEdit', params: { restauranteId: restaurante.id } }" custom v-slot="{ navigate }">
                  <button @click="navigate" class="btn btn-primary btn-sm edit" data-cy="entityEditButton">
                    <font-awesome-icon icon="pencil-alt"></font-awesome-icon>
                    <span class="d-none d-md-inline" v-text="$t('entity.action.edit')">Edit</span>
                  </button>
                </router-link>
                <b-button
                  v-on:click="prepareRemove(restaurante)"
                  variant="danger"
                  class="btn btn-sm"
                  data-cy="entityDeleteButton"
                  v-b-modal.removeEntity
                >
                  <font-awesome-icon icon="times"></font-awesome-icon>
                  <span class="d-none d-md-inline" v-text="$t('entity.action.delete')">Delete</span>
                </b-button>
              </div>
            </td>
          </tr>
        </tbody>
      </table>
    </div>
    <b-modal ref="removeEntity" id="removeEntity">
      <span slot="modal-title"
        ><span id="efoodApp.restaurante.delete.question" data-cy="restauranteDeleteDialogHeading" v-text="$t('entity.delete.title')"
          >Confirm delete operation</span
        ></span
      >
      <div class="modal-body">
        <p id="jhi-delete-restaurante-heading" v-text="$t('efoodApp.restaurante.delete.question', { id: removeId })">
          Are you sure you want to delete this Restaurante?
        </p>
      </div>
      <div slot="modal-footer">
        <button type="button" class="btn btn-secondary" v-text="$t('entity.action.cancel')" v-on:click="closeDialog()">Cancel</button>
        <button
          type="button"
          class="btn btn-primary"
          id="jhi-confirm-delete-restaurante"
          data-cy="entityConfirmDeleteButton"
          v-text="$t('entity.action.delete')"
          v-on:click="removeRestaurante()"
        >
          Delete
        </button>
      </div>
    </b-modal>
  </div>
</template>

<script lang="ts" src="./restaurante.component.ts"></script>
