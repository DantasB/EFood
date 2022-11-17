package com.xpto.efood.service.dto;

import java.io.Serializable;
import java.util.Objects;
import javax.validation.constraints.*;

/**
 * A DTO for the {@link com.xpto.efood.domain.Pedir} entity.
 */
public class PedirDTO implements Serializable {

    private Long id;

    private String nomeUsuario;

    @NotNull
    private String enderecoUsuario;

    private Long telefoneUsuario;

    private String nomeentregador;

    private Long telefonerestaurante;

    private String emailrestaurante;

    private String ruarestaurante;

    private String ceprestaurante;

    private String idPedido;

    private String horaPedido;

    private String custoPedido;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNomeUsuario() {
        return nomeUsuario;
    }

    public void setNomeUsuario(String nomeUsuario) {
        this.nomeUsuario = nomeUsuario;
    }

    public String getEnderecoUsuario() {
        return enderecoUsuario;
    }

    public void setEnderecoUsuario(String enderecoUsuario) {
        this.enderecoUsuario = enderecoUsuario;
    }

    public Long getTelefoneUsuario() {
        return telefoneUsuario;
    }

    public void setTelefoneUsuario(Long telefoneUsuario) {
        this.telefoneUsuario = telefoneUsuario;
    }

    public String getNomeentregador() {
        return nomeentregador;
    }

    public void setNomeentregador(String nomeentregador) {
        this.nomeentregador = nomeentregador;
    }

    public Long getTelefonerestaurante() {
        return telefonerestaurante;
    }

    public void setTelefonerestaurante(Long telefonerestaurante) {
        this.telefonerestaurante = telefonerestaurante;
    }

    public String getEmailrestaurante() {
        return emailrestaurante;
    }

    public void setEmailrestaurante(String emailrestaurante) {
        this.emailrestaurante = emailrestaurante;
    }

    public String getRuarestaurante() {
        return ruarestaurante;
    }

    public void setRuarestaurante(String ruarestaurante) {
        this.ruarestaurante = ruarestaurante;
    }

    public String getCeprestaurante() {
        return ceprestaurante;
    }

    public void setCeprestaurante(String ceprestaurante) {
        this.ceprestaurante = ceprestaurante;
    }

    public String getIdPedido() {
        return idPedido;
    }

    public void setIdPedido(String idPedido) {
        this.idPedido = idPedido;
    }

    public String getHoraPedido() {
        return horaPedido;
    }

    public void setHoraPedido(String horaPedido) {
        this.horaPedido = horaPedido;
    }

    public String getCustoPedido() {
        return custoPedido;
    }

    public void setCustoPedido(String custoPedido) {
        this.custoPedido = custoPedido;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof PedirDTO)) {
            return false;
        }

        PedirDTO pedirDTO = (PedirDTO) o;
        if (this.id == null) {
            return false;
        }
        return Objects.equals(this.id, pedirDTO.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.id);
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "PedirDTO{" +
            "id=" + getId() +
            ", nomeUsuario='" + getNomeUsuario() + "'" +
            ", enderecoUsuario='" + getEnderecoUsuario() + "'" +
            ", telefoneUsuario=" + getTelefoneUsuario() +
            ", nomeentregador='" + getNomeentregador() + "'" +
            ", telefonerestaurante=" + getTelefonerestaurante() +
            ", emailrestaurante='" + getEmailrestaurante() + "'" +
            ", ruarestaurante='" + getRuarestaurante() + "'" +
            ", ceprestaurante='" + getCeprestaurante() + "'" +
            ", idPedido='" + getIdPedido() + "'" +
            ", horaPedido='" + getHoraPedido() + "'" +
            ", custoPedido='" + getCustoPedido() + "'" +
            "}";
    }
}
