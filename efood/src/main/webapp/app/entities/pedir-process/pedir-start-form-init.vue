<template>
  <div class="row justify-content-center">
    <div class="col-10">
      <form name="editForm" role="form" novalidate v-on:submit.prevent="save()">
        <h2
          id="efoodApp.pedirStartForm.home.createOrEditLabel"
          data-cy="PedirStartFormCreateUpdateHeading"
          v-text="$t('efoodApp.pedirStartForm.home.createOrEditLabel')"
        >
          Create or edit a PedirStartForm
        </h2>
        <div v-if="pedirProcess.processInstance">
          <akip-show-process-definition :processDefinition="pedirProcess.processInstance.processDefinition">
            <template v-slot:body>
              <hr />
              <div v-if="pedirProcess.pedir">
                <div class="form-group">
                  <label class="form-control-label" v-text="$t('efoodApp.pedirStartForm.nomeUsuario')" for="pedir-start-form-nomeUsuario"
                    >Nome Usuario</label
                  >
                  <input
                    type="text"
                    class="form-control"
                    name="nomeUsuario"
                    id="pedir-start-form-nomeUsuario"
                    data-cy="nomeUsuario"
                    :class="{ valid: !$v.pedirProcess.pedir.nomeUsuario.$invalid, invalid: $v.pedirProcess.pedir.nomeUsuario.$invalid }"
                    v-model="$v.pedirProcess.pedir.nomeUsuario.$model"
                  />
                </div>
                <div class="form-group">
                  <label
                    class="form-control-label"
                    v-text="$t('efoodApp.pedirStartForm.enderecoUsuario')"
                    for="pedir-start-form-enderecoUsuario"
                    >Endereco Usuario</label
                  >
                  <input
                    type="text"
                    class="form-control"
                    name="enderecoUsuario"
                    id="pedir-start-form-enderecoUsuario"
                    data-cy="enderecoUsuario"
                    :class="{
                      valid: !$v.pedirProcess.pedir.enderecoUsuario.$invalid,
                      invalid: $v.pedirProcess.pedir.enderecoUsuario.$invalid,
                    }"
                    v-model="$v.pedirProcess.pedir.enderecoUsuario.$model"
                    required
                  />
                  <div v-if="$v.pedirProcess.pedir.enderecoUsuario.$anyDirty && $v.pedirProcess.pedir.enderecoUsuario.$invalid">
                    <small
                      class="form-text text-danger"
                      v-if="!$v.pedirProcess.pedir.enderecoUsuario.required"
                      v-text="$t('entity.validation.required')"
                    >
                      This field is required.
                    </small>
                  </div>
                </div>
                <div class="form-group">
                  <label
                    class="form-control-label"
                    v-text="$t('efoodApp.pedirStartForm.telefoneUsuario')"
                    for="pedir-start-form-telefoneUsuario"
                    >Telefone Usuario</label
                  >
                  <input
                    type="number"
                    class="form-control"
                    name="telefoneUsuario"
                    id="pedir-start-form-telefoneUsuario"
                    data-cy="telefoneUsuario"
                    :class="{
                      valid: !$v.pedirProcess.pedir.telefoneUsuario.$invalid,
                      invalid: $v.pedirProcess.pedir.telefoneUsuario.$invalid,
                    }"
                    v-model.number="$v.pedirProcess.pedir.telefoneUsuario.$model"
                  />
                </div>
                <div class="form-group">
                  <label class="form-control-label" v-text="$t('efoodApp.pedirStartForm.cpfUsuario')" for="pedir-start-form-cpfUsuario"
                    >Cpf Usuario</label
                  >
                  <input
                    type="number"
                    class="form-control"
                    name="cpfUsuario"
                    id="pedir-start-form-cpfUsuario"
                    data-cy="cpfUsuario"
                    :class="{ valid: !$v.pedirProcess.pedir.cpfUsuario.$invalid, invalid: $v.pedirProcess.pedir.cpfUsuario.$invalid }"
                    v-model.number="$v.pedirProcess.pedir.cpfUsuario.$model"
                  />
                </div>
                <div class="form-group">
                  <label class="form-control-label" v-text="$t('efoodApp.pedirStartForm.emailUsuario')" for="pedir-start-form-emailUsuario"
                    >Email Usuario</label
                  >
                  <input
                    type="text"
                    class="form-control"
                    name="emailUsuario"
                    id="pedir-start-form-emailUsuario"
                    data-cy="emailUsuario"
                    :class="{ valid: !$v.pedirProcess.pedir.emailUsuario.$invalid, invalid: $v.pedirProcess.pedir.emailUsuario.$invalid }"
                    v-model="$v.pedirProcess.pedir.emailUsuario.$model"
                    required
                  />
                  <div v-if="$v.pedirProcess.pedir.emailUsuario.$anyDirty && $v.pedirProcess.pedir.emailUsuario.$invalid">
                    <small
                      class="form-text text-danger"
                      v-if="!$v.pedirProcess.pedir.emailUsuario.required"
                      v-text="$t('entity.validation.required')"
                    >
                      This field is required.
                    </small>
                  </div>
                </div>
              </div>
            </template>
          </akip-show-process-definition>
          <br />
          <button type="button" id="cancel-save" class="btn btn-secondary" v-on:click="previousState()">
            <font-awesome-icon icon="ban"></font-awesome-icon>&nbsp;<span v-text="$t('entity.action.cancel')">Cancel</span>
          </button>
          <button
            type="submit"
            id="save-entity"
            data-cy="entityCreateSaveButton"
            :disabled="$v.pedirProcess.$invalid || isSaving"
            class="btn btn-primary"
          >
            <font-awesome-icon icon="play"></font-awesome-icon>&nbsp;<span>Start</span>
          </button>
        </div>
      </form>
    </div>
  </div>
</template>
<script lang="ts" src="./pedir-start-form-init.component.ts"></script>
