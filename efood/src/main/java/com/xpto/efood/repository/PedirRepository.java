package com.xpto.efood.repository;

import com.xpto.efood.domain.Pedir;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

/**
 * Spring Data SQL repository for the Pedir entity.
 */
@SuppressWarnings("unused")
@Repository
public interface PedirRepository extends JpaRepository<Pedir, Long> {}
