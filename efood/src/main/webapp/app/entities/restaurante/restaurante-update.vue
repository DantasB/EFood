<template>
  <div class="row justify-content-center">
    <div class="col-8">
      <form name="editForm" role="form" novalidate v-on:submit.prevent="save()">
        <h2
          id="efoodApp.restaurante.home.createOrEditLabel"
          data-cy="RestauranteCreateUpdateHeading"
          v-text="$t('efoodApp.restaurante.home.createOrEditLabel')"
        >
          Create or edit a Restaurante
        </h2>
        <div>
          <div class="form-group" v-if="restaurante.id">
            <label for="id" v-text="$t('global.field.id')">ID</label>
            <input type="text" class="form-control" id="id" name="id" v-model="restaurante.id" readonly />
          </div>
          <div class="form-group">
            <label class="form-control-label" v-text="$t('efoodApp.restaurante.telefoneRestaurante')" for="restaurante-telefoneRestaurante"
              >Telefone Restaurante</label
            >
            <input
              type="number"
              class="form-control"
              name="telefoneRestaurante"
              id="restaurante-telefoneRestaurante"
              data-cy="telefoneRestaurante"
              :class="{ valid: !$v.restaurante.telefoneRestaurante.$invalid, invalid: $v.restaurante.telefoneRestaurante.$invalid }"
              v-model.number="$v.restaurante.telefoneRestaurante.$model"
            />
          </div>
          <div class="form-group">
            <label class="form-control-label" v-text="$t('efoodApp.restaurante.emailRestaurante')" for="restaurante-emailRestaurante"
              >Email Restaurante</label
            >
            <input
              type="text"
              class="form-control"
              name="emailRestaurante"
              id="restaurante-emailRestaurante"
              data-cy="emailRestaurante"
              :class="{ valid: !$v.restaurante.emailRestaurante.$invalid, invalid: $v.restaurante.emailRestaurante.$invalid }"
              v-model="$v.restaurante.emailRestaurante.$model"
            />
          </div>
          <div class="form-group">
            <label class="form-control-label" v-text="$t('efoodApp.restaurante.ruaRestaurante')" for="restaurante-ruaRestaurante"
              >Rua Restaurante</label
            >
            <input
              type="text"
              class="form-control"
              name="ruaRestaurante"
              id="restaurante-ruaRestaurante"
              data-cy="ruaRestaurante"
              :class="{ valid: !$v.restaurante.ruaRestaurante.$invalid, invalid: $v.restaurante.ruaRestaurante.$invalid }"
              v-model="$v.restaurante.ruaRestaurante.$model"
            />
          </div>
          <div class="form-group">
            <label class="form-control-label" v-text="$t('efoodApp.restaurante.cepRestaurante')" for="restaurante-cepRestaurante"
              >Cep Restaurante</label
            >
            <input
              type="number"
              class="form-control"
              name="cepRestaurante"
              id="restaurante-cepRestaurante"
              data-cy="cepRestaurante"
              :class="{ valid: !$v.restaurante.cepRestaurante.$invalid, invalid: $v.restaurante.cepRestaurante.$invalid }"
              v-model.number="$v.restaurante.cepRestaurante.$model"
            />
          </div>
          <div class="form-group">
            <label class="form-control-label" v-text="$t('efoodApp.restaurante.nomeEntregador')" for="restaurante-nomeEntregador"
              >Nome Entregador</label
            >
            <input
              type="text"
              class="form-control"
              name="nomeEntregador"
              id="restaurante-nomeEntregador"
              data-cy="nomeEntregador"
              :class="{ valid: !$v.restaurante.nomeEntregador.$invalid, invalid: $v.restaurante.nomeEntregador.$invalid }"
              v-model="$v.restaurante.nomeEntregador.$model"
            />
          </div>
          <div class="form-group">
            <label class="form-control-label" v-text="$t('efoodApp.restaurante.cnpjRestaurante')" for="restaurante-cnpjRestaurante"
              >Cnpj Restaurante</label
            >
            <input
              type="number"
              class="form-control"
              name="cnpjRestaurante"
              id="restaurante-cnpjRestaurante"
              data-cy="cnpjRestaurante"
              :class="{ valid: !$v.restaurante.cnpjRestaurante.$invalid, invalid: $v.restaurante.cnpjRestaurante.$invalid }"
              v-model.number="$v.restaurante.cnpjRestaurante.$model"
            />
          </div>
          <div class="form-group">
            <label class="form-control-label" v-text="$t('efoodApp.restaurante.nomeRestaurante')" for="restaurante-nomeRestaurante"
              >Nome Restaurante</label
            >
            <input
              type="text"
              class="form-control"
              name="nomeRestaurante"
              id="restaurante-nomeRestaurante"
              data-cy="nomeRestaurante"
              :class="{ valid: !$v.restaurante.nomeRestaurante.$invalid, invalid: $v.restaurante.nomeRestaurante.$invalid }"
              v-model="$v.restaurante.nomeRestaurante.$model"
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
            :disabled="$v.restaurante.$invalid || isSaving"
            class="btn btn-primary"
          >
            <font-awesome-icon icon="save"></font-awesome-icon>&nbsp;<span v-text="$t('entity.action.save')">Save</span>
          </button>
        </div>
      </form>
    </div>
  </div>
</template>
<script lang="ts" src="./restaurante-update.component.ts"></script>
