package com.xpto.efood.service.dto;

import static org.assertj.core.api.Assertions.assertThat;

import com.xpto.efood.web.rest.TestUtil;
import org.junit.jupiter.api.Test;

class RestauranteDTOTest {

    @Test
    void dtoEqualsVerifier() throws Exception {
        TestUtil.equalsVerifier(RestauranteDTO.class);
        RestauranteDTO restauranteDTO1 = new RestauranteDTO();
        restauranteDTO1.setId(1L);
        RestauranteDTO restauranteDTO2 = new RestauranteDTO();
        assertThat(restauranteDTO1).isNotEqualTo(restauranteDTO2);
        restauranteDTO2.setId(restauranteDTO1.getId());
        assertThat(restauranteDTO1).isEqualTo(restauranteDTO2);
        restauranteDTO2.setId(2L);
        assertThat(restauranteDTO1).isNotEqualTo(restauranteDTO2);
        restauranteDTO1.setId(null);
        assertThat(restauranteDTO1).isNotEqualTo(restauranteDTO2);
    }
}
