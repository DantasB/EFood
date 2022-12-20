package com.xpto.efood.domain;

import java.io.Serializable;
import javax.persistence.*;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

/**
 * A Pedido.
 */
@Entity
@Table(name = "pedido")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class Pedido implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceGenerator")
    @SequenceGenerator(name = "sequenceGenerator")
    private Long id;

    @Column(name = "nome_pedido")
    private String nomePedido;

    @Column(name = "custo_pedido")
    private Float custoPedido;

    // jhipster-needle-entity-add-field - JHipster will add fields here
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Pedido id(Long id) {
        this.id = id;
        return this;
    }

    public String getNomePedido() {
        return this.nomePedido;
    }

    public Pedido nomePedido(String nomePedido) {
        this.nomePedido = nomePedido;
        return this;
    }

    public void setNomePedido(String nomePedido) {
        this.nomePedido = nomePedido;
    }

    public Float getCustoPedido() {
        return this.custoPedido;
    }

    public Pedido custoPedido(Float custoPedido) {
        this.custoPedido = custoPedido;
        return this;
    }

    public void setCustoPedido(Float custoPedido) {
        this.custoPedido = custoPedido;
    }

    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Pedido)) {
            return false;
        }
        return id != null && id.equals(((Pedido) o).id);
    }

    @Override
    public int hashCode() {
        // see https://vladmihalcea.com/how-to-implement-equals-and-hashcode-using-the-jpa-entity-identifier/
        return getClass().hashCode();
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "Pedido{" +
            "id=" + getId() +
            ", nomePedido='" + getNomePedido() + "'" +
            ", custoPedido=" + getCustoPedido() +
            "}";
    }
}
