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

    @NotNull
    @Column(name = "email_usuario", nullable = false)
    private String emailUsuario;

    @Column(name = "telefone_usuario")
    private Long telefoneUsuario;

    @Column(name = "cpf_usuario")
    private Long cpfUsuario;

    @ManyToOne
    private Restaurante restaurante;

    @ManyToOne
    private Pedido pedido;

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

    public String getEmailUsuario() {
        return this.emailUsuario;
    }

    public Pedir emailUsuario(String emailUsuario) {
        this.emailUsuario = emailUsuario;
        return this;
    }

    public void setEmailUsuario(String emailUsuario) {
        this.emailUsuario = emailUsuario;
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

    public Long getCpfUsuario() {
        return this.cpfUsuario;
    }

    public Pedir cpfUsuario(Long cpfUsuario) {
        this.cpfUsuario = cpfUsuario;
        return this;
    }

    public void setCpfUsuario(Long cpfUsuario) {
        this.cpfUsuario = cpfUsuario;
    }

    public Restaurante getRestaurante() {
        return this.restaurante;
    }

    public Pedir restaurante(Restaurante restaurante) {
        this.setRestaurante(restaurante);
        return this;
    }

    public void setRestaurante(Restaurante restaurante) {
        this.restaurante = restaurante;
    }

    public Pedido getPedido() {
        return this.pedido;
    }

    public Pedir pedido(Pedido pedido) {
        this.setPedido(pedido);
        return this;
    }

    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
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
            ", emailUsuario='" + getEmailUsuario() + "'" +
            ", telefoneUsuario=" + getTelefoneUsuario() +
            ", cpfUsuario=" + getCpfUsuario() +
            "}";
    }
}
