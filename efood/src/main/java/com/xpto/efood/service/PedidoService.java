package com.xpto.efood.service;

import com.xpto.efood.domain.Pedido;
import com.xpto.efood.repository.PedidoRepository;
import com.xpto.efood.service.dto.PedidoDTO;
import com.xpto.efood.service.mapper.PedidoMapper;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Service Implementation for managing {@link Pedido}.
 */
@Service
@Transactional
public class PedidoService {

    private final Logger log = LoggerFactory.getLogger(PedidoService.class);

    private final PedidoRepository pedidoRepository;

    private final PedidoMapper pedidoMapper;

    public PedidoService(PedidoRepository pedidoRepository, PedidoMapper pedidoMapper) {
        this.pedidoRepository = pedidoRepository;
        this.pedidoMapper = pedidoMapper;
    }

    /**
     * Save a pedido.
     *
     * @param pedidoDTO the entity to save.
     * @return the persisted entity.
     */
    public PedidoDTO save(PedidoDTO pedidoDTO) {
        log.debug("Request to save Pedido : {}", pedidoDTO);
        Pedido pedido = pedidoMapper.toEntity(pedidoDTO);
        pedido = pedidoRepository.save(pedido);
        return pedidoMapper.toDto(pedido);
    }

    /**
     * Partially update a pedido.
     *
     * @param pedidoDTO the entity to update partially.
     * @return the persisted entity.
     */
    public Optional<PedidoDTO> partialUpdate(PedidoDTO pedidoDTO) {
        log.debug("Request to partially update Pedido : {}", pedidoDTO);

        return pedidoRepository
            .findById(pedidoDTO.getId())
            .map(
                existingPedido -> {
                    pedidoMapper.partialUpdate(existingPedido, pedidoDTO);
                    return existingPedido;
                }
            )
            .map(pedidoRepository::save)
            .map(pedidoMapper::toDto);
    }

    /**
     * Get all the pedidos.
     *
     * @return the list of entities.
     */
    @Transactional(readOnly = true)
    public List<PedidoDTO> findAll() {
        log.debug("Request to get all Pedidos");
        return pedidoRepository.findAll().stream().map(pedidoMapper::toDto).collect(Collectors.toCollection(LinkedList::new));
    }

    /**
     * Get one pedido by id.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    @Transactional(readOnly = true)
    public Optional<PedidoDTO> findOne(Long id) {
        log.debug("Request to get Pedido : {}", id);
        return pedidoRepository.findById(id).map(pedidoMapper::toDto);
    }

    /**
     * Delete the pedido by id.
     *
     * @param id the id of the entity.
     */
    public void delete(Long id) {
        log.debug("Request to delete Pedido : {}", id);
        pedidoRepository.deleteById(id);
    }
}
