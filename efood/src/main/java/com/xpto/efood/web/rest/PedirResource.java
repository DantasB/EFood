package com.xpto.efood.web.rest;

import com.xpto.efood.repository.PedirRepository;
import com.xpto.efood.service.PedirService;
import com.xpto.efood.service.dto.PedirDTO;
import com.xpto.efood.web.rest.errors.BadRequestAlertException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import javax.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tech.jhipster.web.util.HeaderUtil;
import tech.jhipster.web.util.ResponseUtil;

/**
 * REST controller for managing {@link com.xpto.efood.domain.Pedir}.
 */
@RestController
@RequestMapping("/api")
public class PedirResource {

    private final Logger log = LoggerFactory.getLogger(PedirResource.class);

    private final PedirService pedirService;

    private final PedirRepository pedirRepository;

    public PedirResource(PedirService pedirService, PedirRepository pedirRepository) {
        this.pedirService = pedirService;
        this.pedirRepository = pedirRepository;
    }

    /**
     * {@code GET  /pedirs} : get all the pedirs.
     *
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of pedirs in body.
     */
    @GetMapping("/pedirs")
    public List<PedirDTO> getAllPedirs() {
        log.debug("REST request to get all Pedirs");
        return pedirService.findAll();
    }

    /**
     * {@code GET  /pedirs/:id} : get the "id" pedir.
     *
     * @param id the id of the pedirDTO to retrieve.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the pedirDTO, or with status {@code 404 (Not Found)}.
     */
    @GetMapping("/pedirs/{id}")
    public ResponseEntity<PedirDTO> getPedir(@PathVariable Long id) {
        log.debug("REST request to get Pedir : {}", id);
        Optional<PedirDTO> pedirDTO = pedirService.findOne(id);
        return ResponseUtil.wrapOrNotFound(pedirDTO);
    }
}
