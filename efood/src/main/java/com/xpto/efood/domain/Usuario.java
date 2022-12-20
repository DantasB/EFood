package com.xpto.efood.domain;

import java.io.Serializable;
import javax.persistence.*;
import javax.validation.constraints.*;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

/**
 * A Usuario.
 */
@Entity
@Table(name = "usuario")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class Usuario implements Serializable {

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

    // jhipster-needle-entity-add-field - JHipster will add fields here
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Usuario id(Long id) {
        this.id = id;
        return this;
    }

    public String getNomeUsuario() {
        return this.nomeUsuario;
    }

    public Usuario nomeUsuario(String nomeUsuario) {
        this.nomeUsuario = nomeUsuario;
        return this;
    }

    public void setNomeUsuario(String nomeUsuario) {
        this.nomeUsuario = nomeUsuario;
    }

    public String getEnderecoUsuario() {
        return this.enderecoUsuario;
    }

    public Usuario enderecoUsuario(String enderecoUsuario) {
        this.enderecoUsuario = enderecoUsuario;
        return this;
    }

    public void setEnderecoUsuario(String enderecoUsuario) {
        this.enderecoUsuario = enderecoUsuario;
    }

    public String getEmailUsuario() {
        return this.emailUsuario;
    }

    public Usuario emailUsuario(String emailUsuario) {
        this.emailUsuario = emailUsuario;
        return this;
    }

    public void setEmailUsuario(String emailUsuario) {
        this.emailUsuario = emailUsuario;
    }

    public Long getTelefoneUsuario() {
        return this.telefoneUsuario;
    }

    public Usuario telefoneUsuario(Long telefoneUsuario) {
        this.telefoneUsuario = telefoneUsuario;
        return this;
    }

    public void setTelefoneUsuario(Long telefoneUsuario) {
        this.telefoneUsuario = telefoneUsuario;
    }

    public Long getCpfUsuario() {
        return this.cpfUsuario;
    }

    public Usuario cpfUsuario(Long cpfUsuario) {
        this.cpfUsuario = cpfUsuario;
        return this;
    }

    public void setCpfUsuario(Long cpfUsuario) {
        this.cpfUsuario = cpfUsuario;
    }

    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Usuario)) {
            return false;
        }
        return id != null && id.equals(((Usuario) o).id);
    }

    @Override
    public int hashCode() {
        // see https://vladmihalcea.com/how-to-implement-equals-and-hashcode-using-the-jpa-entity-identifier/
        return getClass().hashCode();
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "Usuario{" +
            "id=" + getId() +
            ", nomeUsuario='" + getNomeUsuario() + "'" +
            ", enderecoUsuario='" + getEnderecoUsuario() + "'" +
            ", emailUsuario='" + getEmailUsuario() + "'" +
            ", telefoneUsuario=" + getTelefoneUsuario() +
            ", cpfUsuario=" + getCpfUsuario() +
            "}";
    }
}
