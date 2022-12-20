package com.xpto.efood.service.mapper;

import com.xpto.efood.domain.*;
import com.xpto.efood.service.dto.UsuarioDTO;
import org.mapstruct.*;

/**
 * Mapper for the entity {@link Usuario} and its DTO {@link UsuarioDTO}.
 */
@Mapper(componentModel = "spring", uses = {})
public interface UsuarioMapper extends EntityMapper<UsuarioDTO, Usuario> {}
