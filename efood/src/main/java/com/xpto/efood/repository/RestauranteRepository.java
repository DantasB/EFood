package com.xpto.efood.repository;

import com.xpto.efood.domain.Restaurante;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

/**
 * Spring Data SQL repository for the Restaurante entity.
 */
@SuppressWarnings("unused")
@Repository
public interface RestauranteRepository extends JpaRepository<Restaurante, Long> {}
