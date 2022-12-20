package com.xpto.efood.service.dto;

import java.io.Serializable;
import java.util.Objects;
import javax.validation.constraints.*;

/**
 * A DTO for the {@link com.xpto.efood.domain.Usuario} entity.
 */
public class UsuarioDTO implements Serializable {

    private Long id;

    private String nomeUsuario;

    @NotNull
    private String enderecoUsuario;

    @NotNull
    private String emailUsuario;

    private Long telefoneUsuario;

    private Long cpfUsuario;

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

    public String getEmailUsuario() {
        return emailUsuario;
    }

    public void setEmailUsuario(String emailUsuario) {
        this.emailUsuario = emailUsuario;
    }

    public Long getTelefoneUsuario() {
        return telefoneUsuario;
    }

    public void setTelefoneUsuario(Long telefoneUsuario) {
        this.telefoneUsuario = telefoneUsuario;
    }

    public Long getCpfUsuario() {
        return cpfUsuario;
    }

    public void setCpfUsuario(Long cpfUsuario) {
        this.cpfUsuario = cpfUsuario;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof UsuarioDTO)) {
            return false;
        }

        UsuarioDTO usuarioDTO = (UsuarioDTO) o;
        if (this.id == null) {
            return false;
        }
        return Objects.equals(this.id, usuarioDTO.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.id);
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "UsuarioDTO{" +
            "id=" + getId() +
            ", nomeUsuario='" + getNomeUsuario() + "'" +
            ", enderecoUsuario='" + getEnderecoUsuario() + "'" +
            ", emailUsuario='" + getEmailUsuario() + "'" +
            ", telefoneUsuario=" + getTelefoneUsuario() +
            ", cpfUsuario=" + getCpfUsuario() +
            "}";
    }
}
