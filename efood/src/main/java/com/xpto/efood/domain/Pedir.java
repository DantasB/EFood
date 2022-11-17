package com.xpto.efood.domain;

import java.io.Serializable;
import javax.persistence.*;
import javax.validation.constraints.*;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

/**
 * A Pedir.
 */
@Entity
@Table(name = "pedir")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class Pedir implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceGenerator")
    @SequenceGenerator(name = "sequenceGenerator")
    private Long id;

    @Column(name = "nome_usuario")
    private String nomeUsuario;

    @NotNull
    @Column(name = "endereco_usuario", nullable = false)
    private String enderecoUsuario;

    @Column(name = "telefone_usuario")
    private Long telefoneUsuario;

    @Column(name = "nomeentregador")
    private String nomeentregador;

    @Column(name = "telefonerestaurante")
    private Long telefonerestaurante;

    @Column(name = "emailrestaurante")
    private String emailrestaurante;

    @Column(name = "ruarestaurante")
    private String ruarestaurante;

    @Column(name = "ceprestaurante")
    private String ceprestaurante;

    @Column(name = "id_pedido")
    private String idPedido;

    @Column(name = "hora_pedido")
    private String horaPedido;

    @Column(name = "custo_pedido")
    private String custoPedido;

    // jhipster-needle-entity-add-field - JHipster will add fields here
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Pedir id(Long id) {
        this.id = id;
        return this;
    }

    public String getNomeUsuario() {
        return this.nomeUsuario;
    }

    public Pedir nomeUsuario(String nomeUsuario) {
        this.nomeUsuario = nomeUsuario;
        return this;
    }

    public void setNomeUsuario(String nomeUsuario) {
        this.nomeUsuario = nomeUsuario;
    }

    public String getEnderecoUsuario() {
        return this.enderecoUsuario;
    }

    public Pedir enderecoUsuario(String enderecoUsuario) {
        this.enderecoUsuario = enderecoUsuario;
        return this;
    }

    public void setEnderecoUsuario(String enderecoUsuario) {
        this.enderecoUsuario = enderecoUsuario;
    }

    public Long getTelefoneUsuario() {
        return this.telefoneUsuario;
    }

    public Pedir telefoneUsuario(Long telefoneUsuario) {
        this.telefoneUsuario = telefoneUsuario;
        return this;
    }

    public void setTelefoneUsuario(Long telefoneUsuario) {
        this.telefoneUsuario = telefoneUsuario;
    }

    public String getNomeentregador() {
        return this.nomeentregador;
    }

    public Pedir nomeentregador(String nomeentregador) {
        this.nomeentregador = nomeentregador;
        return this;
    }

    public void setNomeentregador(String nomeentregador) {
        this.nomeentregador = nomeentregador;
    }

    public Long getTelefonerestaurante() {
        return this.telefonerestaurante;
    }

    public Pedir telefonerestaurante(Long telefonerestaurante) {
        this.telefonerestaurante = telefonerestaurante;
        return this;
    }

    public void setTelefonerestaurante(Long telefonerestaurante) {
        this.telefonerestaurante = telefonerestaurante;
    }

    public String getEmailrestaurante() {
        return this.emailrestaurante;
    }

    public Pedir emailrestaurante(String emailrestaurante) {
        this.emailrestaurante = emailrestaurante;
        return this;
    }

    public void setEmailrestaurante(String emailrestaurante) {
        this.emailrestaurante = emailrestaurante;
    }

    public String getRuarestaurante() {
        return this.ruarestaurante;
    }

    public Pedir ruarestaurante(String ruarestaurante) {
        this.ruarestaurante = ruarestaurante;
        return this;
    }

    public void setRuarestaurante(String ruarestaurante) {
        this.ruarestaurante = ruarestaurante;
    }

    public String getCeprestaurante() {
        return this.ceprestaurante;
    }

    public Pedir ceprestaurante(String ceprestaurante) {
        this.ceprestaurante = ceprestaurante;
        return this;
    }

    public void setCeprestaurante(String ceprestaurante) {
        this.ceprestaurante = ceprestaurante;
    }

    public String getIdPedido() {
        return this.idPedido;
    }

    public Pedir idPedido(String idPedido) {
        this.idPedido = idPedido;
        return this;
    }

    public void setIdPedido(String idPedido) {
        this.idPedido = idPedido;
    }

    public String getHoraPedido() {
        return this.horaPedido;
    }

    public Pedir horaPedido(String horaPedido) {
        this.horaPedido = horaPedido;
        return this;
    }

    public void setHoraPedido(String horaPedido) {
        this.horaPedido = horaPedido;
    }

    public String getCustoPedido() {
        return this.custoPedido;
    }

    public Pedir custoPedido(String custoPedido) {
        this.custoPedido = custoPedido;
        return this;
    }

    public void setCustoPedido(String custoPedido) {
        this.custoPedido = custoPedido;
    }

    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Pedir)) {
            return false;
        }
        return id != null && id.equals(((Pedir) o).id);
    }

    @Override
    public int hashCode() {
        // see https://vladmihalcea.com/how-to-implement-equals-and-hashcode-using-the-jpa-entity-identifier/
        return getClass().hashCode();
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "Pedir{" +
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
