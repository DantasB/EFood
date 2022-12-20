package com.xpto.efood.service.dto;

import java.io.Serializable;
import java.util.Objects;

/**
 * A DTO for the {@link com.xpto.efood.domain.Pedido} entity.
 */
public class PedidoDTO implements Serializable {

    private Long id;

    private String nomePedido;

    private Float custoPedido;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNomePedido() {
        return nomePedido;
    }

    public void setNomePedido(String nomePedido) {
        this.nomePedido = nomePedido;
    }

    public Float getCustoPedido() {
        return custoPedido;
    }

    public void setCustoPedido(Float custoPedido) {
        this.custoPedido = custoPedido;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof PedidoDTO)) {
            return false;
        }

        PedidoDTO pedidoDTO = (PedidoDTO) o;
        if (this.id == null) {
            return false;
        }
        return Objects.equals(this.id, pedidoDTO.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.id);
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "PedidoDTO{" +
            "id=" + getId() +
            ", nomePedido='" + getNomePedido() + "'" +
            ", custoPedido=" + getCustoPedido() +
            "}";
    }
}
