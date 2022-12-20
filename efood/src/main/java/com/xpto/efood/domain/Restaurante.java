package com.xpto.efood.domain;

import java.io.Serializable;
import javax.persistence.*;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

/**
 * A Restaurante.
 */
@Entity
@Table(name = "restaurante")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class Restaurante implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceGenerator")
    @SequenceGenerator(name = "sequenceGenerator")
    private Long id;

    @Column(name = "telefone_restaurante")
    private Long telefoneRestaurante;

    @Column(name = "email_restaurante")
    private String emailRestaurante;

    @Column(name = "rua_restaurante")
    private String ruaRestaurante;

    @Column(name = "cep_restaurante")
    private Long cepRestaurante;

    @Column(name = "nome_entregador")
    private String nomeEntregador;

    @Column(name = "cnpj_restaurante")
    private Long cnpjRestaurante;

    @Column(name = "nome_restaurante")
    private String nomeRestaurante;

    // jhipster-needle-entity-add-field - JHipster will add fields here
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Restaurante id(Long id) {
        this.id = id;
        return this;
    }

    public Long getTelefoneRestaurante() {
        return this.telefoneRestaurante;
    }

    public Restaurante telefoneRestaurante(Long telefoneRestaurante) {
        this.telefoneRestaurante = telefoneRestaurante;
        return this;
    }

    public void setTelefoneRestaurante(Long telefoneRestaurante) {
        this.telefoneRestaurante = telefoneRestaurante;
    }

    public String getEmailRestaurante() {
        return this.emailRestaurante;
    }

    public Restaurante emailRestaurante(String emailRestaurante) {
        this.emailRestaurante = emailRestaurante;
        return this;
    }

    public void setEmailRestaurante(String emailRestaurante) {
        this.emailRestaurante = emailRestaurante;
    }

    public String getRuaRestaurante() {
        return this.ruaRestaurante;
    }

    public Restaurante ruaRestaurante(String ruaRestaurante) {
        this.ruaRestaurante = ruaRestaurante;
        return this;
    }

    public void setRuaRestaurante(String ruaRestaurante) {
        this.ruaRestaurante = ruaRestaurante;
    }

    public Long getCepRestaurante() {
        return this.cepRestaurante;
    }

    public Restaurante cepRestaurante(Long cepRestaurante) {
        this.cepRestaurante = cepRestaurante;
        return this;
    }

    public void setCepRestaurante(Long cepRestaurante) {
        this.cepRestaurante = cepRestaurante;
    }

    public String getNomeEntregador() {
        return this.nomeEntregador;
    }

    public Restaurante nomeEntregador(String nomeEntregador) {
        this.nomeEntregador = nomeEntregador;
        return this;
    }

    public void setNomeEntregador(String nomeEntregador) {
        this.nomeEntregador = nomeEntregador;
    }

    public Long getCnpjRestaurante() {
        return this.cnpjRestaurante;
    }

    public Restaurante cnpjRestaurante(Long cnpjRestaurante) {
        this.cnpjRestaurante = cnpjRestaurante;
        return this;
    }

    public void setCnpjRestaurante(Long cnpjRestaurante) {
        this.cnpjRestaurante = cnpjRestaurante;
    }

    public String getNomeRestaurante() {
        return this.nomeRestaurante;
    }

    public Restaurante nomeRestaurante(String nomeRestaurante) {
        this.nomeRestaurante = nomeRestaurante;
        return this;
    }

    public void setNomeRestaurante(String nomeRestaurante) {
        this.nomeRestaurante = nomeRestaurante;
    }

    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Restaurante)) {
            return false;
        }
        return id != null && id.equals(((Restaurante) o).id);
    }

    @Override
    public int hashCode() {
        // see https://vladmihalcea.com/how-to-implement-equals-and-hashcode-using-the-jpa-entity-identifier/
        return getClass().hashCode();
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "Restaurante{" +
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
