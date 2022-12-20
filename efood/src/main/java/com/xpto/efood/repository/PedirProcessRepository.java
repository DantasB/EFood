package com.xpto.efood.repository;

import com.xpto.efood.domain.PedirProcess;
import java.util.Optional;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

/**
 * Spring Data SQL repository for the PedirProcess entity.
 */
@SuppressWarnings("unused")
@Repository
public interface PedirProcessRepository extends JpaRepository<PedirProcess, Long> {
    Optional<PedirProcess> findByProcessInstanceId(Long processInstanceId);
}
