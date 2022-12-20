<template>
  <div class="row justify-content-center">
    <div class="col-8">
      <form name="editForm" role="form" novalidate v-on:submit.prevent="save()">
        <h2
          id="efoodApp.usuario.home.createOrEditLabel"
          data-cy="UsuarioCreateUpdateHeading"
          v-text="$t('efoodApp.usuario.home.createOrEditLabel')"
        >
          Create or edit a Usuario
        </h2>
        <div>
          <div class="form-group" v-if="usuario.id">
            <label for="id" v-text="$t('global.field.id')">ID</label>
            <input type="text" class="form-control" id="id" name="id" v-model="usuario.id" readonly />
          </div>
          <div class="form-group">
            <label class="form-control-label" v-text="$t('efoodApp.usuario.nomeUsuario')" for="usuario-nomeUsuario">Nome Usuario</label>
            <input
              type="text"
              class="form-control"
              name="nomeUsuario"
              id="usuario-nomeUsuario"
              data-cy="nomeUsuario"
              :class="{ valid: !$v.usuario.nomeUsuario.$invalid, invalid: $v.usuario.nomeUsuario.$invalid }"
              v-model="$v.usuario.nomeUsuario.$model"
            />
          </div>
          <div class="form-group">
            <label class="form-control-label" v-text="$t('efoodApp.usuario.enderecoUsuario')" for="usuario-enderecoUsuario"
              >Endereco Usuario</label
            >
            <input
              type="text"
              class="form-control"
              name="enderecoUsuario"
              id="usuario-enderecoUsuario"
              data-cy="enderecoUsuario"
              :class="{ valid: !$v.usuario.enderecoUsuario.$invalid, invalid: $v.usuario.enderecoUsuario.$invalid }"
              v-model="$v.usuario.enderecoUsuario.$model"
              required
            />
            <div v-if="$v.usuario.enderecoUsuario.$anyDirty && $v.usuario.enderecoUsuario.$invalid">
              <small class="form-text text-danger" v-if="!$v.usuario.enderecoUsuario.required" v-text="$t('entity.validation.required')">
                This field is required.
              </small>
            </div>
          </div>
          <div class="form-group">
            <label class="form-control-label" v-text="$t('efoodApp.usuario.emailUsuario')" for="usuario-emailUsuario">Email Usuario</label>
            <input
              type="text"
              class="form-control"
              name="emailUsuario"
              id="usuario-emailUsuario"
              data-cy="emailUsuario"
              :class="{ valid: !$v.usuario.emailUsuario.$invalid, invalid: $v.usuario.emailUsuario.$invalid }"
              v-model="$v.usuario.emailUsuario.$model"
              required
            />
            <div v-if="$v.usuario.emailUsuario.$anyDirty && $v.usuario.emailUsuario.$invalid">
              <small class="form-text text-danger" v-if="!$v.usuario.emailUsuario.required" v-text="$t('entity.validation.required')">
                This field is required.
              </small>
            </div>
          </div>
          <div class="form-group">
            <label class="form-control-label" v-text="$t('efoodApp.usuario.telefoneUsuario')" for="usuario-telefoneUsuario"
              >Telefone Usuario</label
            >
            <input
              type="number"
              class="form-control"
              name="telefoneUsuario"
              id="usuario-telefoneUsuario"
              data-cy="telefoneUsuario"
              :class="{ valid: !$v.usuario.telefoneUsuario.$invalid, invalid: $v.usuario.telefoneUsuario.$invalid }"
              v-model.number="$v.usuario.telefoneUsuario.$model"
            />
          </div>
          <div class="form-group">
            <label class="form-control-label" v-text="$t('efoodApp.usuario.cpfUsuario')" for="usuario-cpfUsuario">Cpf Usuario</label>
            <input
              type="number"
              class="form-control"
              name="cpfUsuario"
              id="usuario-cpfUsuario"
              data-cy="cpfUsuario"
              :class="{ valid: !$v.usuario.cpfUsuario.$invalid, invalid: $v.usuario.cpfUsuario.$invalid }"
              v-model.number="$v.usuario.cpfUsuario.$model"
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
            :disabled="$v.usuario.$invalid || isSaving"
            class="btn btn-primary"
          >
            <font-awesome-icon icon="save"></font-awesome-icon>&nbsp;<span v-text="$t('entity.action.save')">Save</span>
          </button>
        </div>
      </form>
    </div>
  </div>
</template>
<script lang="ts" src="./usuario-update.component.ts"></script>
