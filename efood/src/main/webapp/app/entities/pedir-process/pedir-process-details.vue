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
                  <label class="form-control-label" v-text="$t('efoodApp.pedirProcess.nomeentregador')">nomeentregador</label>
                  <input
                    readonly
                    type="text"
                    class="form-control"
                    name="nomeentregador"
                    id="pedir-nomeentregador"
                    data-cy="nomeentregador"
                    v-model="pedirProcess.pedir.nomeentregador"
                  />
                </div>
              </div>
              <div class="card-body py-0">
                <div class="form-group">
                  <label class="form-control-label" v-text="$t('efoodApp.pedirProcess.telefonerestaurante')">telefonerestaurante</label>
                  <input
                    readonly
                    type="text"
                    class="form-control"
                    name="telefonerestaurante"
                    id="pedir-telefonerestaurante"
                    data-cy="telefonerestaurante"
                    v-model="pedirProcess.pedir.telefonerestaurante"
                  />
                </div>
              </div>
              <div class="card-body py-0">
                <div class="form-group">
                  <label class="form-control-label" v-text="$t('efoodApp.pedirProcess.emailrestaurante')">emailrestaurante</label>
                  <input
                    readonly
                    type="text"
                    class="form-control"
                    name="emailrestaurante"
                    id="pedir-emailrestaurante"
                    data-cy="emailrestaurante"
                    v-model="pedirProcess.pedir.emailrestaurante"
                  />
                </div>
              </div>
              <div class="card-body py-0">
                <div class="form-group">
                  <label class="form-control-label" v-text="$t('efoodApp.pedirProcess.ruarestaurante')">ruarestaurante</label>
                  <input
                    readonly
                    type="text"
                    class="form-control"
                    name="ruarestaurante"
                    id="pedir-ruarestaurante"
                    data-cy="ruarestaurante"
                    v-model="pedirProcess.pedir.ruarestaurante"
                  />
                </div>
              </div>
              <div class="card-body py-0">
                <div class="form-group">
                  <label class="form-control-label" v-text="$t('efoodApp.pedirProcess.ceprestaurante')">ceprestaurante</label>
                  <input
                    readonly
                    type="text"
                    class="form-control"
                    name="ceprestaurante"
                    id="pedir-ceprestaurante"
                    data-cy="ceprestaurante"
                    v-model="pedirProcess.pedir.ceprestaurante"
                  />
                </div>
              </div>
              <div class="card-body py-0">
                <div class="form-group">
                  <label class="form-control-label" v-text="$t('efoodApp.pedirProcess.idPedido')">idPedido</label>
                  <input
                    readonly
                    type="text"
                    class="form-control"
                    name="idPedido"
                    id="pedir-idPedido"
                    data-cy="idPedido"
                    v-model="pedirProcess.pedir.idPedido"
                  />
                </div>
              </div>
              <div class="card-body py-0">
                <div class="form-group">
                  <label class="form-control-label" v-text="$t('efoodApp.pedirProcess.horaPedido')">horaPedido</label>
                  <input
                    readonly
                    type="text"
                    class="form-control"
                    name="horaPedido"
                    id="pedir-horaPedido"
                    data-cy="horaPedido"
                    v-model="pedirProcess.pedir.horaPedido"
                  />
                </div>
              </div>
              <div class="card-body py-0">
                <div class="form-group">
                  <label class="form-control-label" v-text="$t('efoodApp.pedirProcess.custoPedido')">custoPedido</label>
                  <input
                    readonly
                    type="text"
                    class="form-control"
                    name="custoPedido"
                    id="pedir-custoPedido"
                    data-cy="custoPedido"
                    v-model="pedirProcess.pedir.custoPedido"
                  />
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
