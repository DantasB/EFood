package com.xpto.efood.web.rest;

import com.xpto.efood.repository.RestauranteRepository;
import com.xpto.efood.service.RestauranteService;
import com.xpto.efood.service.dto.RestauranteDTO;
import com.xpto.efood.web.rest.errors.BadRequestAlertException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tech.jhipster.web.util.HeaderUtil;
import tech.jhipster.web.util.ResponseUtil;

/**
 * REST controller for managing {@link com.xpto.efood.domain.Restaurante}.
 */
@RestController
@RequestMapping("/api")
public class RestauranteResource {

    private final Logger log = LoggerFactory.getLogger(RestauranteResource.class);

    private static final String ENTITY_NAME = "restaurante";

    @Value("${jhipster.clientApp.name}")
    private String applicationName;

    private final RestauranteService restauranteService;

    private final RestauranteRepository restauranteRepository;

    public RestauranteResource(RestauranteService restauranteService, RestauranteRepository restauranteRepository) {
        this.restauranteService = restauranteService;
        this.restauranteRepository = restauranteRepository;
    }

    /**
     * {@code POST  /restaurantes} : Create a new restaurante.
     *
     * @param restauranteDTO the restauranteDTO to create.
     * @return the {@link ResponseEntity} with status {@code 201 (Created)} and with body the new restauranteDTO, or with status {@code 400 (Bad Request)} if the restaurante has already an ID.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PostMapping("/restaurantes")
    public ResponseEntity<RestauranteDTO> createRestaurante(@RequestBody RestauranteDTO restauranteDTO) throws URISyntaxException {
        log.debug("REST request to save Restaurante : {}", restauranteDTO);
        if (restauranteDTO.getId() != null) {
            throw new BadRequestAlertException("A new restaurante cannot already have an ID", ENTITY_NAME, "idexists");
        }
        RestauranteDTO result = restauranteService.save(restauranteDTO);
        return ResponseEntity
            .created(new URI("/api/restaurantes/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(applicationName, true, ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * {@code PUT  /restaurantes/:id} : Updates an existing restaurante.
     *
     * @param id the id of the restauranteDTO to save.
     * @param restauranteDTO the restauranteDTO to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated restauranteDTO,
     * or with status {@code 400 (Bad Request)} if the restauranteDTO is not valid,
     * or with status {@code 500 (Internal Server Error)} if the restauranteDTO couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PutMapping("/restaurantes/{id}")
    public ResponseEntity<RestauranteDTO> updateRestaurante(
        @PathVariable(value = "id", required = false) final Long id,
        @RequestBody RestauranteDTO restauranteDTO
    ) throws URISyntaxException {
        log.debug("REST request to update Restaurante : {}, {}", id, restauranteDTO);
        if (restauranteDTO.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        if (!Objects.equals(id, restauranteDTO.getId())) {
            throw new BadRequestAlertException("Invalid ID", ENTITY_NAME, "idinvalid");
        }

        if (!restauranteRepository.existsById(id)) {
            throw new BadRequestAlertException("Entity not found", ENTITY_NAME, "idnotfound");
        }

        RestauranteDTO result = restauranteService.save(restauranteDTO);
        return ResponseEntity
            .ok()
            .headers(HeaderUtil.createEntityUpdateAlert(applicationName, true, ENTITY_NAME, restauranteDTO.getId().toString()))
            .body(result);
    }

    /**
     * {@code PATCH  /restaurantes/:id} : Partial updates given fields of an existing restaurante, field will ignore if it is null
     *
     * @param id the id of the restauranteDTO to save.
     * @param restauranteDTO the restauranteDTO to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated restauranteDTO,
     * or with status {@code 400 (Bad Request)} if the restauranteDTO is not valid,
     * or with status {@code 404 (Not Found)} if the restauranteDTO is not found,
     * or with status {@code 500 (Internal Server Error)} if the restauranteDTO couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PatchMapping(value = "/restaurantes/{id}", consumes = "application/merge-patch+json")
    public ResponseEntity<RestauranteDTO> partialUpdateRestaurante(
        @PathVariable(value = "id", required = false) final Long id,
        @RequestBody RestauranteDTO restauranteDTO
    ) throws URISyntaxException {
        log.debug("REST request to partial update Restaurante partially : {}, {}", id, restauranteDTO);
        if (restauranteDTO.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        if (!Objects.equals(id, restauranteDTO.getId())) {
            throw new BadRequestAlertException("Invalid ID", ENTITY_NAME, "idinvalid");
        }

        if (!restauranteRepository.existsById(id)) {
            throw new BadRequestAlertException("Entity not found", ENTITY_NAME, "idnotfound");
        }

        Optional<RestauranteDTO> result = restauranteService.partialUpdate(restauranteDTO);

        return ResponseUtil.wrapOrNotFound(
            result,
            HeaderUtil.createEntityUpdateAlert(applicationName, true, ENTITY_NAME, restauranteDTO.getId().toString())
        );
    }

    /**
     * {@code GET  /restaurantes} : get all the restaurantes.
     *
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of restaurantes in body.
     */
    @GetMapping("/restaurantes")
    public List<RestauranteDTO> getAllRestaurantes() {
        log.debug("REST request to get all Restaurantes");
        return restauranteService.findAll();
    }

    /**
     * {@code GET  /restaurantes/:id} : get the "id" restaurante.
     *
     * @param id the id of the restauranteDTO to retrieve.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the restauranteDTO, or with status {@code 404 (Not Found)}.
     */
    @GetMapping("/restaurantes/{id}")
    public ResponseEntity<RestauranteDTO> getRestaurante(@PathVariable Long id) {
        log.debug("REST request to get Restaurante : {}", id);
        Optional<RestauranteDTO> restauranteDTO = restauranteService.findOne(id);
        return ResponseUtil.wrapOrNotFound(restauranteDTO);
    }

    /**
     * {@code DELETE  /restaurantes/:id} : delete the "id" restaurante.
     *
     * @param id the id of the restauranteDTO to delete.
     * @return the {@link ResponseEntity} with status {@code 204 (NO_CONTENT)}.
     */
    @DeleteMapping("/restaurantes/{id}")
    public ResponseEntity<Void> deleteRestaurante(@PathVariable Long id) {
        log.debug("REST request to delete Restaurante : {}", id);
        restauranteService.delete(id);
        return ResponseEntity
            .noContent()
            .headers(HeaderUtil.createEntityDeletionAlert(applicationName, true, ENTITY_NAME, id.toString()))
            .build();
    }
}
