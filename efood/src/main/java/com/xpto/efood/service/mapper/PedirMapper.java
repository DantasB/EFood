package com.xpto.efood.service.mapper;

import com.xpto.efood.domain.*;
import com.xpto.efood.service.dto.PedirDTO;
import org.mapstruct.*;

/**
 * Mapper for the entity {@link Pedir} and its DTO {@link PedirDTO}.
 */
@Mapper(componentModel = "spring", uses = {})
public interface PedirMapper extends EntityMapper<PedirDTO, Pedir> {}
