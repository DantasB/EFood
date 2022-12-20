package com.xpto.efood.service.dto;

import java.io.Serializable;
import java.util.Objects;

/**
 * A DTO for the {@link com.xpto.efood.domain.Restaurante} entity.
 */
public class RestauranteDTO implements Serializable {

    private Long id;

    private Long telefoneRestaurante;

    private String emailRestaurante;

    private String ruaRestaurante;

    private Long cepRestaurante;

    private String nomeEntregador;

    private Long cnpjRestaurante;

    private String nomeRestaurante;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getTelefoneRestaurante() {
        return telefoneRestaurante;
    }

    public void setTelefoneRestaurante(Long telefoneRestaurante) {
        this.telefoneRestaurante = telefoneRestaurante;
    }

    public String getEmailRestaurante() {
        return emailRestaurante;
    }

    public void setEmailRestaurante(String emailRestaurante) {
        this.emailRestaurante = emailRestaurante;
    }

    public String getRuaRestaurante() {
        return ruaRestaurante;
    }

    public void setRuaRestaurante(String ruaRestaurante) {
        this.ruaRestaurante = ruaRestaurante;
    }

    public Long getCepRestaurante() {
        return cepRestaurante;
    }

    public void setCepRestaurante(Long cepRestaurante) {
        this.cepRestaurante = cepRestaurante;
    }

    public String getNomeEntregador() {
        return nomeEntregador;
    }

    public void setNomeEntregador(String nomeEntregador) {
        this.nomeEntregador = nomeEntregador;
    }

    public Long getCnpjRestaurante() {
        return cnpjRestaurante;
    }

    public void setCnpjRestaurante(Long cnpjRestaurante) {
        this.cnpjRestaurante = cnpjRestaurante;
    }

    public String getNomeRestaurante() {
        return nomeRestaurante;
    }

    public void setNomeRestaurante(String nomeRestaurante) {
        this.nomeRestaurante = nomeRestaurante;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof RestauranteDTO)) {
            return false;
        }

        RestauranteDTO restauranteDTO = (RestauranteDTO) o;
        if (this.id == null) {
            return false;
        }
        return Objects.equals(this.id, restauranteDTO.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.id);
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "RestauranteDTO{" +
            "id=" + getId() +
            ", telefoneRestaurante=" + getTelefoneRestaurante() +
            ", emailRestaurante='" + getEmailRestaurante() + "'" +
            ", ruaRestaurante='" + getRuaRestaurante() + "'" +
            ", cepRestaurante=" + getCepRestaurante() +
            ", nomeEntregador='" + getNomeEntregador() + "'" +
            ", cnpjRestaurante=" + getCnpjRestaurante() +
            ", nomeRestaurante='" + getNomeRestaurante() + "'" +
            "}";
    }
}
