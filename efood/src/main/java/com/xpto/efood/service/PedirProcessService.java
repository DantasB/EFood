package com.xpto.efood.service;

import com.xpto.efood.domain.PedirProcess;
import com.xpto.efood.repository.PedirProcessRepository;
import com.xpto.efood.repository.PedirRepository;
import com.xpto.efood.service.dto.PedirProcessDTO;
import com.xpto.efood.service.mapper.PedirProcessMapper;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import org.akip.domain.ProcessInstance;
import org.akip.service.ProcessInstanceService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Service Implementation for managing {@link PedirProcess}.
 */
@Service
@Transactional
public class PedirProcessService {

    public static final String BPMN_PROCESS_DEFINITION_ID = "PedirProcess";

    private final Logger log = LoggerFactory.getLogger(PedirProcessService.class);

    private final ProcessInstanceService processInstanceService;

    private final PedirRepository pedirRepository;

    private final PedirProcessRepository pedirProcessRepository;

    private final PedirProcessMapper pedirProcessMapper;

    public PedirProcessService(
        ProcessInstanceService processInstanceService,
        PedirRepository pedirRepository,
        PedirProcessRepository pedirProcessRepository,
        PedirProcessMapper pedirProcessMapper
    ) {
        this.processInstanceService = processInstanceService;
        this.pedirRepository = pedirRepository;
        this.pedirProcessRepository = pedirProcessRepository;
        this.pedirProcessMapper = pedirProcessMapper;
    }

    /**
     * Save a pedirProcess.
     *
     * @param pedirProcessDTO the entity to save.
     * @return the persisted entity.
     */
    public PedirProcessDTO create(PedirProcessDTO pedirProcessDTO) {
        log.debug("Request to save PedirProcess : {}", pedirProcessDTO);

        PedirProcess pedirProcess = pedirProcessMapper.toEntity(pedirProcessDTO);

        //Saving the domainEntity
        pedirRepository.save(pedirProcess.getPedir());

        //Creating the process instance in the Camunda and setting it in the process entity
        ProcessInstance processInstance = processInstanceService.create(
            BPMN_PROCESS_DEFINITION_ID,
            "Pedir#" + pedirProcess.getPedir().getId(),
            pedirProcess
        );
        pedirProcess.setProcessInstance(processInstance);

        //Saving the process entity
        pedirProcess = pedirProcessRepository.save(pedirProcess);
        return pedirProcessMapper.toDto(pedirProcess);
    }

    /**
     * Get all the pedirProcesss.
     *
     * @return the list of entities.
     */
    @Transactional(readOnly = true)
    public List<PedirProcessDTO> findAll() {
        log.debug("Request to get all PedirProcesss");
        return pedirProcessRepository.findAll().stream().map(pedirProcessMapper::toDto).collect(Collectors.toCollection(LinkedList::new));
    }

    /**
     * Get one pedirProcess by id.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    @Transactional(readOnly = true)
    public Optional<PedirProcessDTO> findOne(Long id) {
        log.debug("Request to get PedirProcess : {}", id);
        return pedirProcessRepository.findById(id).map(pedirProcessMapper::toDto);
    }

    /**
     * Get one pedirProcess by id.
     *
     * @param processInstanceId the id of the processInstance associated to the entity.
     * @return the entity.
     */
    @Transactional(readOnly = true)
    public Optional<PedirProcessDTO> findByProcessInstanceId(Long processInstanceId) {
        log.debug("Request to get PedirProcess by  processInstanceId: {}", processInstanceId);
        return pedirProcessRepository.findByProcessInstanceId(processInstanceId).map(pedirProcessMapper::toDto);
    }
}
