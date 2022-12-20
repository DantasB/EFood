package com.xpto.efood.service.mapper;

import com.xpto.efood.domain.*;
import com.xpto.efood.service.dto.PedirProcessDTO;
import org.akip.service.mapper.ProcessInstanceMapper;
import org.mapstruct.*;

/**
 * Mapper for the entity {@link PedirProcess} and its DTO {@link PedirProcessDTO}.
 */
@Mapper(componentModel = "spring", uses = { ProcessInstanceMapper.class, PedirMapper.class })
public interface PedirProcessMapper extends EntityMapper<PedirProcessDTO, PedirProcess> {
    @Mapping(target = "processInstance", source = "processInstance")
    @Mapping(target = "pedir", source = "pedir")
    PedirProcessDTO toDto(PedirProcess s);
}
