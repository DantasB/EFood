<template>
  <div class="row justify-content-center">
    <div class="col-10">
      <div v-if="pedirProcess.processInstance">
        <h2 class="jh-entity-heading" data-cy="pedirProcessDetailsHeading">
          <span v-text="$t('efoodApp.pedirProcess.detail.title')">PedirProcess</span> {{ pedirProcess.id }}
        </h2>
        <akip-show-process-instance :processInstance="pedirProcess.processInstance">
          <template v-slot:title>
            <span v-text="$t('efoodApp.pedirProcess.detail.title')">PedirProcess</span> #{{ pedirProcess.id }}
          </template>
          <template v-slot:details>
            <div class="card" v-if="pedirProcess.pedir">
              <h5 class="card-header">
                <span class="title"> Pedir #{{ pedirProcess.pedir.id }} </span>
              </h5>
              <div class="card-body py-0">
                <div class="form-group">
                  <label class="form-control-label" v-text="$t('efoodApp.pedirProcess.nomeUsuario')">nomeUsuario</label>
                  <input
                    readonly
                    type="text"
                    class="form-control"
                    name="nomeUsuario"
                    id="pedir-nomeUsuario"
                    data-cy="nomeUsuario"
                    v-model="pedirProcess.pedir.nomeUsuario"
                  />
                </div>
              </div>
              <div class="card-body py-0">
                <div class="form-group">
                  <label class="form-control-label" v-text="$t('efoodApp.pedirProcess.enderecoUsuario')">enderecoUsuario</label>
                  <input
                    readonly
                    type="text"
                    class="form-control"
                    name="enderecoUsuario"
                    id="pedir-enderecoUsuario"
                    data-cy="enderecoUsuario"
                    v-model="pedirProcess.pedir.enderecoUsuario"
                  />
                </div>
              </div>
              <div class="card-body py-0">
                <div class="form-group">
                  <label class="form-control-label" v-text="$t('efoodApp.pedirProcess.emailUsuario')">emailUsuario</label>
                  <input
                    readonly
                    type="text"
                    class="form-control"
                    name="emailUsuario"
                    id="pedir-emailUsuario"
                    data-cy="emailUsuario"
                    v-model="pedirProcess.pedir.emailUsuario"
                  />
                </div>
              </div>
              <div class="card-body py-0">
                <div class="form-group">
                  <label class="form-control-label" v-text="$t('efoodApp.pedirProcess.telefoneUsuario')">telefoneUsuario</label>
                  <input
                    readonly
                    type="text"
                    class="form-control"
                    name="telefoneUsuario"
                    id="pedir-telefoneUsuario"
                    data-cy="telefoneUsuario"
                    v-model="pedirProcess.pedir.telefoneUsuario"
                  />
                </div>
              </div>
              <div class="card-body py-0">
                <div class="form-group">
                  <label class="form-control-label" v-text="$t('efoodApp.pedirProcess.cpfUsuario')">cpfUsuario</label>
                  <input
                    readonly
                    type="text"
                    class="form-control"
                    name="cpfUsuario"
                    id="pedir-cpfUsuario"
                    data-cy="cpfUsuario"
                    v-model="pedirProcess.pedir.cpfUsuario"
                  />
                </div>
              </div>
              <div class="card-body py-0">
                <div class="form-group">
                  <label class="form-control-label" v-text="$t('efoodApp.pedirProcess.restaurante')" for="pedir-process-restaurante"
                    >Restaurante</label
                  >
                  <input
                    v-if="pedirProcess.pedir.restaurante"
                    readonly
                    type="text"
                    class="form-control"
                    name="restaurante"
                    id="pedir-restaurante"
                    data-cy="restaurante"
                    :value="pedirProcess.pedir.restaurante.nomeRestaurante"
                  />
                  <input
                    v-else
                    readonly
                    type="text"
                    class="form-control"
                    name="restaurante"
                    id="pedir-restaurante"
                    data-cy="restaurante"
                    value=""
                  />
                </div>
              </div>
              <div class="card-body py-0">
                <div class="form-group">
                  <label class="form-control-label" v-text="$t('efoodApp.pedirProcess.pedido')" for="pedir-process-pedido">Pedido</label>
                  <input
                    v-if="pedirProcess.pedir.pedido"
                    readonly
                    type="text"
                    class="form-control"
                    name="pedido"
                    id="pedir-pedido"
                    data-cy="pedido"
                    :value="pedirProcess.pedir.pedido.nomePedido"
                  />
                  <input v-else readonly type="text" class="form-control" name="pedido" id="pedir-pedido" data-cy="pedido" value="" />
                </div>
              </div>
            </div>
          </template>
        </akip-show-process-instance>
        <br />
        <button type="submit" v-on:click.prevent="previousState()" class="btn btn-info" data-cy="entityDetailsBackButton">
          <font-awesome-icon icon="arrow-left"></font-awesome-icon>&nbsp;<span v-text="$t('entity.action.back')"> Back</span>
        </button>
      </div>
    </div>
  </div>
</template>

<script lang="ts" src="./pedir-process-details.component.ts"></script>
