package com.xpto.efood.service;

import com.xpto.efood.domain.Restaurante;
import com.xpto.efood.repository.RestauranteRepository;
import com.xpto.efood.service.dto.RestauranteDTO;
import com.xpto.efood.service.mapper.RestauranteMapper;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Service Implementation for managing {@link Restaurante}.
 */
@Service
@Transactional
public class RestauranteService {

    private final Logger log = LoggerFactory.getLogger(RestauranteService.class);

    private final RestauranteRepository restauranteRepository;

    private final RestauranteMapper restauranteMapper;

    public RestauranteService(RestauranteRepository restauranteRepository, RestauranteMapper restauranteMapper) {
        this.restauranteRepository = restauranteRepository;
        this.restauranteMapper = restauranteMapper;
    }

    /**
     * Save a restaurante.
     *
     * @param restauranteDTO the entity to save.
     * @return the persisted entity.
     */
    public RestauranteDTO save(RestauranteDTO restauranteDTO) {
        log.debug("Request to save Restaurante : {}", restauranteDTO);
        Restaurante restaurante = restauranteMapper.toEntity(restauranteDTO);
        restaurante = restauranteRepository.save(restaurante);
        return restauranteMapper.toDto(restaurante);
    }

    /**
     * Partially update a restaurante.
     *
     * @param restauranteDTO the entity to update partially.
     * @return the persisted entity.
     */
    public Optional<RestauranteDTO> partialUpdate(RestauranteDTO restauranteDTO) {
        log.debug("Request to partially update Restaurante : {}", restauranteDTO);

        return restauranteRepository
            .findById(restauranteDTO.getId())
            .map(
                existingRestaurante -> {
                    restauranteMapper.partialUpdate(existingRestaurante, restauranteDTO);
                    return existingRestaurante;
                }
            )
            .map(restauranteRepository::save)
            .map(restauranteMapper::toDto);
    }

    /**
     * Get all the restaurantes.
     *
     * @return the list of entities.
     */
    @Transactional(readOnly = true)
    public List<RestauranteDTO> findAll() {
        log.debug("Request to get all Restaurantes");
        return restauranteRepository.findAll().stream().map(restauranteMapper::toDto).collect(Collectors.toCollection(LinkedList::new));
    }

    /**
     * Get one restaurante by id.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    @Transactional(readOnly = true)
    public Optional<RestauranteDTO> findOne(Long id) {
        log.debug("Request to get Restaurante : {}", id);
        return restauranteRepository.findById(id).map(restauranteMapper::toDto);
    }

    /**
     * Delete the restaurante by id.
     *
     * @param id the id of the entity.
     */
    public void delete(Long id) {
        log.debug("Request to delete Restaurante : {}", id);
        restauranteRepository.deleteById(id);
    }
}
