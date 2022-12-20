package com.xpto.efood.service.mapper;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class RestauranteMapperTest {

    private RestauranteMapper restauranteMapper;

    @BeforeEach
    public void setUp() {
        restauranteMapper = new RestauranteMapperImpl();
    }
}
