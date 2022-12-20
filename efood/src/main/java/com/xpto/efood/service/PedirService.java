package com.xpto.efood.service;

import com.xpto.efood.domain.Pedir;
import com.xpto.efood.repository.PedirRepository;
import com.xpto.efood.service.dto.PedirDTO;
import com.xpto.efood.service.mapper.PedirMapper;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Service Implementation for managing {@link Pedir}.
 */
@Service
@Transactional
public class PedirService {

    private final Logger log = LoggerFactory.getLogger(PedirService.class);

    private final PedirRepository pedirRepository;

    private final PedirMapper pedirMapper;

    public PedirService(PedirRepository pedirRepository, PedirMapper pedirMapper) {
        this.pedirRepository = pedirRepository;
        this.pedirMapper = pedirMapper;
    }

    /**
     * Save a pedir.
     *
     * @param pedirDTO the entity to save.
     * @return the persisted entity.
     */
    public PedirDTO save(PedirDTO pedirDTO) {
        log.debug("Request to save Pedir : {}", pedirDTO);
        Pedir pedir = pedirMapper.toEntity(pedirDTO);
        pedir = pedirRepository.save(pedir);
        return pedirMapper.toDto(pedir);
    }

    /**
     * Partially update a pedir.
     *
     * @param pedirDTO the entity to update partially.
     * @return the persisted entity.
     */
    public Optional<PedirDTO> partialUpdate(PedirDTO pedirDTO) {
        log.debug("Request to partially update Pedir : {}", pedirDTO);

        return pedirRepository
            .findById(pedirDTO.getId())
            .map(
                existingPedir -> {
                    pedirMapper.partialUpdate(existingPedir, pedirDTO);
                    return existingPedir;
                }
            )
            .map(pedirRepository::save)
            .map(pedirMapper::toDto);
    }

    /**
     * Get all the pedirs.
     *
     * @return the list of entities.
     */
    @Transactional(readOnly = true)
    public List<PedirDTO> findAll() {
        log.debug("Request to get all Pedirs");
        return pedirRepository.findAll().stream().map(pedirMapper::toDto).collect(Collectors.toCollection(LinkedList::new));
    }

    /**
     * Get one pedir by id.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    @Transactional(readOnly = true)
    public Optional<PedirDTO> findOne(Long id) {
        log.debug("Request to get Pedir : {}", id);
        return pedirRepository.findById(id).map(pedirMapper::toDto);
    }

    /**
     * Delete the pedir by id.
     *
     * @param id the id of the entity.
     */
    public void delete(Long id) {
        log.debug("Request to delete Pedir : {}", id);
        pedirRepository.deleteById(id);
    }
}
