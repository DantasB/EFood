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

    @NotNull
    private String emailUsuario;

    private Long telefoneUsuario;

    private Long cpfUsuario;

    private RestauranteDTO restaurante;

    private PedidoDTO pedido;

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

    public RestauranteDTO getRestaurante() {
        return restaurante;
    }

    public void setRestaurante(RestauranteDTO restaurante) {
        this.restaurante = restaurante;
    }

    public PedidoDTO getPedido() {
        return pedido;
    }

    public void setPedido(PedidoDTO pedido) {
        this.pedido = pedido;
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
            ", emailUsuario='" + getEmailUsuario() + "'" +
            ", telefoneUsuario=" + getTelefoneUsuario() +
            ", cpfUsuario=" + getCpfUsuario() +
            ", restaurante=" + getRestaurante() +
            ", pedido=" + getPedido() +
            "}";
    }
}
