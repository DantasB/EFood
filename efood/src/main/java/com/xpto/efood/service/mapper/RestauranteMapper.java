package com.xpto.efood.service.mapper;

import com.xpto.efood.domain.*;
import com.xpto.efood.service.dto.RestauranteDTO;
import org.mapstruct.*;

/**
 * Mapper for the entity {@link Restaurante} and its DTO {@link RestauranteDTO}.
 */
@Mapper(componentModel = "spring", uses = {})
public interface RestauranteMapper extends EntityMapper<RestauranteDTO, Restaurante> {
    @Named("nomeRestaurante")
    @BeanMapping(ignoreByDefault = true)
    @Mapping(target = "id", source = "id")
    @Mapping(target = "nomeRestaurante", source = "nomeRestaurante")
    RestauranteDTO toDtoNomeRestaurante(Restaurante restaurante);
}
