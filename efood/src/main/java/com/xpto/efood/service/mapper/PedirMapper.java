package com.xpto.efood.service.mapper;

import com.xpto.efood.domain.*;
import com.xpto.efood.service.dto.PedirDTO;
import org.mapstruct.*;

/**
 * Mapper for the entity {@link Pedir} and its DTO {@link PedirDTO}.
 */
@Mapper(componentModel = "spring", uses = { RestauranteMapper.class, PedidoMapper.class })
public interface PedirMapper extends EntityMapper<PedirDTO, Pedir> {
    @Mapping(target = "restaurante", source = "restaurante", qualifiedByName = "nomeRestaurante")
    @Mapping(target = "pedido", source = "pedido", qualifiedByName = "nomePedido")
    PedirDTO toDto(Pedir s);
}
