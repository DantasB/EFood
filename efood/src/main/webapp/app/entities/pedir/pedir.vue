<template>
  <div>
    <h2 id="page-heading" data-cy="PedirHeading">
      <span v-text="$t('efoodApp.pedir.home.title')" id="pedir-heading">Pedirs</span>
      <div class="d-flex justify-content-end">
        <button class="btn btn-info mr-2" v-on:click="handleSyncList" :disabled="isFetching">
          <font-awesome-icon icon="sync" :spin="isFetching"></font-awesome-icon>
          <span v-text="$t('efoodApp.pedir.home.refreshListLabel')">Refresh List</span>
        </button>
      </div>
    </h2>
    <br />
    <div class="alert alert-warning" v-if="!isFetching && pedirs && pedirs.length === 0">
      <span v-text="$t('efoodApp.pedir.home.notFound')">No pedirs found</span>
    </div>
    <div class="table-responsive" v-if="pedirs && pedirs.length > 0">
      <table class="table table-striped" aria-describedby="pedirs">
        <thead>
          <tr>
            <th scope="row"><span v-text="$t('global.field.id')">ID</span></th>
            <th scope="row"><span v-text="$t('efoodApp.pedir.nomeUsuario')">Nome Usuario</span></th>
            <th scope="row"><span v-text="$t('efoodApp.pedir.enderecoUsuario')">Endereco Usuario</span></th>
            <th scope="row"><span v-text="$t('efoodApp.pedir.emailUsuario')">Email Usuario</span></th>
            <th scope="row"><span v-text="$t('efoodApp.pedir.telefoneUsuario')">Telefone Usuario</span></th>
            <th scope="row"><span v-text="$t('efoodApp.pedir.cpfUsuario')">Cpf Usuario</span></th>
            <th scope="row"><span v-text="$t('efoodApp.pedir.restaurante')">Restaurante</span></th>
            <th scope="row"><span v-text="$t('efoodApp.pedir.pedido')">Pedido</span></th>
            <th scope="row"></th>
          </tr>
        </thead>
        <tbody>
          <tr v-for="pedir in pedirs" :key="pedir.id" data-cy="entityTable">
            <td>
              <router-link :to="{ name: 'PedirView', params: { pedirId: pedir.id } }">{{ pedir.id }}</router-link>
            </td>
            <td>{{ pedir.nomeUsuario }}</td>
            <td>{{ pedir.enderecoUsuario }}</td>
            <td>{{ pedir.emailUsuario }}</td>
            <td>{{ pedir.telefoneUsuario }}</td>
            <td>{{ pedir.cpfUsuario }}</td>
            <td>
              <div v-if="pedir.restaurante">
                <router-link :to="{ name: 'RestauranteView', params: { restauranteId: pedir.restaurante.id } }">{{
                  pedir.restaurante.nomeRestaurante
                }}</router-link>
              </div>
            </td>
            <td>
              <div v-if="pedir.pedido">
                <router-link :to="{ name: 'PedidoView', params: { pedidoId: pedir.pedido.id } }">{{ pedir.pedido.nomePedido }}</router-link>
              </div>
            </td>
            <td class="text-right">
              <div class="btn-group">
                <router-link :to="{ name: 'PedirView', params: { pedirId: pedir.id } }" custom v-slot="{ navigate }">
                  <button @click="navigate" class="btn btn-info btn-sm details" data-cy="entityDetailsButton">
                    <font-awesome-icon icon="eye"></font-awesome-icon>
                    <span class="d-none d-md-inline" v-text="$t('entity.action.view')">View</span>
                  </button>
                </router-link>
              </div>
            </td>
          </tr>
        </tbody>
      </table>
    </div>
    <b-modal ref="removeEntity" id="removeEntity">
      <span slot="modal-title"
        ><span id="efoodApp.pedir.delete.question" data-cy="pedirDeleteDialogHeading" v-text="$t('entity.delete.title')"
          >Confirm delete operation</span
        ></span
      >
      <div class="modal-body">
        <p id="jhi-delete-pedir-heading" v-text="$t('efoodApp.pedir.delete.question', { id: removeId })">
          Are you sure you want to delete this Pedir?
        </p>
      </div>
      <div slot="modal-footer">
        <button type="button" class="btn btn-secondary" v-text="$t('entity.action.cancel')" v-on:click="closeDialog()">Cancel</button>
        <button
          type="button"
          class="btn btn-primary"
          id="jhi-confirm-delete-pedir"
          data-cy="entityConfirmDeleteButton"
          v-text="$t('entity.action.delete')"
          v-on:click="removePedir()"
        >
          Delete
        </button>
      </div>
    </b-modal>
  </div>
</template>

<script lang="ts" src="./pedir.component.ts"></script>
