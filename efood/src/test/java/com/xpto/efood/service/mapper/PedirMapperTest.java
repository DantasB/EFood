package com.xpto.efood.service.mapper;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class PedirMapperTest {

    private PedirMapper pedirMapper;

    @BeforeEach
    public void setUp() {
        pedirMapper = new PedirMapperImpl();
    }
}
