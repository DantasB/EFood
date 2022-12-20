package com.xpto.efood.service.mapper;

import com.xpto.efood.domain.*;
import com.xpto.efood.service.dto.PedidoDTO;
import org.mapstruct.*;

/**
 * Mapper for the entity {@link Pedido} and its DTO {@link PedidoDTO}.
 */
@Mapper(componentModel = "spring", uses = {})
public interface PedidoMapper extends EntityMapper<PedidoDTO, Pedido> {
    @Named("nomePedido")
    @BeanMapping(ignoreByDefault = true)
    @Mapping(target = "id", source = "id")
    @Mapping(target = "nomePedido", source = "nomePedido")
    PedidoDTO toDtoNomePedido(Pedido pedido);
}
