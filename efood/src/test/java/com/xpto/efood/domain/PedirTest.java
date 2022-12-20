package com.xpto.efood.domain;

import static org.assertj.core.api.Assertions.assertThat;

import com.xpto.efood.web.rest.TestUtil;
import org.junit.jupiter.api.Test;

class PedirTest {

    @Test
    void equalsVerifier() throws Exception {
        TestUtil.equalsVerifier(Pedir.class);
        Pedir pedir1 = new Pedir();
        pedir1.setId(1L);
        Pedir pedir2 = new Pedir();
        pedir2.setId(pedir1.getId());
        assertThat(pedir1).isEqualTo(pedir2);
        pedir2.setId(2L);
        assertThat(pedir1).isNotEqualTo(pedir2);
        pedir1.setId(null);
        assertThat(pedir1).isNotEqualTo(pedir2);
    }
}
