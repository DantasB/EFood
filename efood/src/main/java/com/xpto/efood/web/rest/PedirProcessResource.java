package com.xpto.efood.web.rest;

import com.xpto.efood.service.PedirProcessService;
import com.xpto.efood.service.dto.PedirProcessDTO;
import com.xpto.efood.web.rest.errors.BadRequestAlertException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tech.jhipster.web.util.HeaderUtil;
import tech.jhipster.web.util.ResponseUtil;

/**
 * REST controller for managing {@link com.xpto.efood.domain.PedirProcess}.
 */
@RestController
@RequestMapping("/api")
public class PedirProcessResource {

    private final Logger log = LoggerFactory.getLogger(PedirProcessResource.class);

    private static final String ENTITY_NAME = "pedirProcess";

    @Value("${jhipster.clientApp.name}")
    private String applicationName;

    private final PedirProcessService pedirProcessService;

    public PedirProcessResource(PedirProcessService pedirProcessService) {
        this.pedirProcessService = pedirProcessService;
    }

    /**
     * {@code POST  /pedir-processes} : Create a new pedirProcess.
     *
     * @param pedirProcessDTO the pedirProcessDTO to create.
     * @return the {@link ResponseEntity} with status {@code 201 (Created)} and with body the new pedirProcessDTO, or with status {@code 400 (Bad Request)} if the pedirProcess has already an ID.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PostMapping("/pedir-processes")
    public ResponseEntity<PedirProcessDTO> create(@RequestBody PedirProcessDTO pedirProcessDTO) throws URISyntaxException {
        log.debug("REST request to save PedirProcess : {}", pedirProcessDTO);
        if (pedirProcessDTO.getId() != null) {
            throw new BadRequestAlertException("A new pedirProcess cannot already have an ID", ENTITY_NAME, "idexists");
        }
        PedirProcessDTO result = pedirProcessService.create(pedirProcessDTO);
        return ResponseEntity
            .created(new URI("/api/pedir-processes/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(applicationName, true, ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * {@code GET  /pedir-processes} : get all the pedirProcesss.
     *
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of pedirProcesss in body.
     */
    @GetMapping("/pedir-processes")
    public List<PedirProcessDTO> getAllPedirProcesss() {
        log.debug("REST request to get all PedirProcesss");
        return pedirProcessService.findAll();
    }

    /**
     * {@code GET  /pedir-processes/:id} : get the "id" pedirProcess.
     *
     * @param processInstanceId the id of the pedirProcessDTO to retrieve.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the pedirProcessDTO, or with status {@code 404 (Not Found)}.
     */
    @GetMapping("/pedir-processes/{processInstanceId}")
    public ResponseEntity<PedirProcessDTO> getByProcessInstanceId(@PathVariable Long processInstanceId) {
        log.debug("REST request to get PedirProcess by processInstanceId : {}", processInstanceId);
        Optional<PedirProcessDTO> pedirProcessDTO = pedirProcessService.findByProcessInstanceId(processInstanceId);
        return ResponseUtil.wrapOrNotFound(pedirProcessDTO);
    }
}
