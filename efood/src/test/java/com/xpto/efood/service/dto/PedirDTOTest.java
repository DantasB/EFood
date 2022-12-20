package com.xpto.efood.service.dto;

import static org.assertj.core.api.Assertions.assertThat;

import com.xpto.efood.web.rest.TestUtil;
import org.junit.jupiter.api.Test;

class PedirDTOTest {

    @Test
    void dtoEqualsVerifier() throws Exception {
        TestUtil.equalsVerifier(PedirDTO.class);
        PedirDTO pedirDTO1 = new PedirDTO();
        pedirDTO1.setId(1L);
        PedirDTO pedirDTO2 = new PedirDTO();
        assertThat(pedirDTO1).isNotEqualTo(pedirDTO2);
        pedirDTO2.setId(pedirDTO1.getId());
        assertThat(pedirDTO1).isEqualTo(pedirDTO2);
        pedirDTO2.setId(2L);
        assertThat(pedirDTO1).isNotEqualTo(pedirDTO2);
        pedirDTO1.setId(null);
        assertThat(pedirDTO1).isNotEqualTo(pedirDTO2);
    }
}
