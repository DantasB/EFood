package com.xpto.efood.process.pedirProcess;

import com.xpto.efood.domain.Pedido;
import com.xpto.efood.domain.Pedir;
import com.xpto.efood.domain.PedirProcess;
import com.xpto.efood.domain.Restaurante;
import com.xpto.efood.service.dto.PedidoDTO;
import com.xpto.efood.service.dto.PedirDTO;
import com.xpto.efood.service.dto.PedirProcessDTO;
import com.xpto.efood.service.dto.RestauranteDTO;
import org.akip.service.mapper.ProcessInstanceMapper;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = { ProcessInstanceMapper.class })
public interface EntregaPedidoUserTaskFormMapper {
    @Mapping(target = "processInstance", source = "processInstance", qualifiedByName = "loadTaskContext")
    PedirProcessDTO toPedirProcessDTO(PedirProcess pedirProcess);

    @BeanMapping(ignoreByDefault = true)
    @Mapping(target = "id", source = "id")
    @Mapping(target = "restaurante", source = "restaurante")
    @Mapping(target = "pedido", source = "pedido")
    PedirDTO toPedirDTO(Pedir pedir);

    @BeanMapping(ignoreByDefault = true)
    @Mapping(target = "id", source = "id")
    @Mapping(target = "nomeRestaurante", source = "nomeRestaurante")
    RestauranteDTO toRestauranteDTO(Restaurante nomeRestaurante);

    @BeanMapping(ignoreByDefault = true)
    @Mapping(target = "id", source = "id")
    @Mapping(target = "nomePedido", source = "nomePedido")
    PedidoDTO toPedidoDTO(Pedido nomePedido);
}
