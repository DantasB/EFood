package com.xpto.efood.web.rest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.Matchers.hasItem;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import com.xpto.efood.IntegrationTest;
import com.xpto.efood.domain.Restaurante;
import com.xpto.efood.repository.RestauranteRepository;
import com.xpto.efood.service.dto.RestauranteDTO;
import com.xpto.efood.service.mapper.RestauranteMapper;
import java.util.List;
import java.util.Random;
import java.util.concurrent.atomic.AtomicLong;
import javax.persistence.EntityManager;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.transaction.annotation.Transactional;

/**
 * Integration tests for the {@link RestauranteResource} REST controller.
 */
@IntegrationTest
@AutoConfigureMockMvc
@WithMockUser
class RestauranteResourceIT {

    private static final Long DEFAULT_TELEFONE_RESTAURANTE = 1L;
    private static final Long UPDATED_TELEFONE_RESTAURANTE = 2L;

    private static final String DEFAULT_EMAIL_RESTAURANTE = "AAAAAAAAAA";
    private static final String UPDATED_EMAIL_RESTAURANTE = "BBBBBBBBBB";

    private static final String DEFAULT_RUA_RESTAURANTE = "AAAAAAAAAA";
    private static final String UPDATED_RUA_RESTAURANTE = "BBBBBBBBBB";

    private static final Long DEFAULT_CEP_RESTAURANTE = 1L;
    private static final Long UPDATED_CEP_RESTAURANTE = 2L;

    private static final String DEFAULT_NOME_ENTREGADOR = "AAAAAAAAAA";
    private static final String UPDATED_NOME_ENTREGADOR = "BBBBBBBBBB";

    private static final Long DEFAULT_CNPJ_RESTAURANTE = 1L;
    private static final Long UPDATED_CNPJ_RESTAURANTE = 2L;

    private static final String DEFAULT_NOME_RESTAURANTE = "AAAAAAAAAA";
    private static final String UPDATED_NOME_RESTAURANTE = "BBBBBBBBBB";

    private static final String ENTITY_API_URL = "/api/restaurantes";
    private static final String ENTITY_API_URL_ID = ENTITY_API_URL + "/{id}";

    private static Random random = new Random();
    private static AtomicLong count = new AtomicLong(random.nextInt() + (2 * Integer.MAX_VALUE));

    @Autowired
    private RestauranteRepository restauranteRepository;

    @Autowired
    private RestauranteMapper restauranteMapper;

    @Autowired
    private EntityManager em;

    @Autowired
    private MockMvc restRestauranteMockMvc;

    private Restaurante restaurante;

    /**
     * Create an entity for this test.
     *
     * This is a static method, as tests for other entities might also need it,
     * if they test an entity which requires the current entity.
     */
    public static Restaurante createEntity(EntityManager em) {
        Restaurante restaurante = new Restaurante()
            .telefoneRestaurante(DEFAULT_TELEFONE_RESTAURANTE)
            .emailRestaurante(DEFAULT_EMAIL_RESTAURANTE)
            .ruaRestaurante(DEFAULT_RUA_RESTAURANTE)
            .cepRestaurante(DEFAULT_CEP_RESTAURANTE)
            .nomeEntregador(DEFAULT_NOME_ENTREGADOR)
            .cnpjRestaurante(DEFAULT_CNPJ_RESTAURANTE)
            .nomeRestaurante(DEFAULT_NOME_RESTAURANTE);
        return restaurante;
    }

    /**
     * Create an updated entity for this test.
     *
     * This is a static method, as tests for other entities might also need it,
     * if they test an entity which requires the current entity.
     */
    public static Restaurante createUpdatedEntity(EntityManager em) {
        Restaurante restaurante = new Restaurante()
            .telefoneRestaurante(UPDATED_TELEFONE_RESTAURANTE)
            .emailRestaurante(UPDATED_EMAIL_RESTAURANTE)
            .ruaRestaurante(UPDATED_RUA_RESTAURANTE)
            .cepRestaurante(UPDATED_CEP_RESTAURANTE)
            .nomeEntregador(UPDATED_NOME_ENTREGADOR)
            .cnpjRestaurante(UPDATED_CNPJ_RESTAURANTE)
            .nomeRestaurante(UPDATED_NOME_RESTAURANTE);
        return restaurante;
    }

    @BeforeEach
    public void initTest() {
        restaurante = createEntity(em);
    }

    @Test
    @Transactional
    void createRestaurante() throws Exception {
        int databaseSizeBeforeCreate = restauranteRepository.findAll().size();
        // Create the Restaurante
        RestauranteDTO restauranteDTO = restauranteMapper.toDto(restaurante);
        restRestauranteMockMvc
            .perform(
                post(ENTITY_API_URL).contentType(MediaType.APPLICATION_JSON).content(TestUtil.convertObjectToJsonBytes(restauranteDTO))
            )
            .andExpect(status().isCreated());

        // Validate the Restaurante in the database
        List<Restaurante> restauranteList = restauranteRepository.findAll();
        assertThat(restauranteList).hasSize(databaseSizeBeforeCreate + 1);
        Restaurante testRestaurante = restauranteList.get(restauranteList.size() - 1);
        assertThat(testRestaurante.getTelefoneRestaurante()).isEqualTo(DEFAULT_TELEFONE_RESTAURANTE);
        assertThat(testRestaurante.getEmailRestaurante()).isEqualTo(DEFAULT_EMAIL_RESTAURANTE);
        assertThat(testRestaurante.getRuaRestaurante()).isEqualTo(DEFAULT_RUA_RESTAURANTE);
        assertThat(testRestaurante.getCepRestaurante()).isEqualTo(DEFAULT_CEP_RESTAURANTE);
        assertThat(testRestaurante.getNomeEntregador()).isEqualTo(DEFAULT_NOME_ENTREGADOR);
        assertThat(testRestaurante.getCnpjRestaurante()).isEqualTo(DEFAULT_CNPJ_RESTAURANTE);
        assertThat(testRestaurante.getNomeRestaurante()).isEqualTo(DEFAULT_NOME_RESTAURANTE);
    }

    @Test
    @Transactional
    void createRestauranteWithExistingId() throws Exception {
        // Create the Restaurante with an existing ID
        restaurante.setId(1L);
        RestauranteDTO restauranteDTO = restauranteMapper.toDto(restaurante);

        int databaseSizeBeforeCreate = restauranteRepository.findAll().size();

        // An entity with an existing ID cannot be created, so this API call must fail
        restRestauranteMockMvc
            .perform(
                post(ENTITY_API_URL).contentType(MediaType.APPLICATION_JSON).content(TestUtil.convertObjectToJsonBytes(restauranteDTO))
            )
            .andExpect(status().isBadRequest());

        // Validate the Restaurante in the database
        List<Restaurante> restauranteList = restauranteRepository.findAll();
        assertThat(restauranteList).hasSize(databaseSizeBeforeCreate);
    }

    @Test
    @Transactional
    void getAllRestaurantes() throws Exception {
        // Initialize the database
        restauranteRepository.saveAndFlush(restaurante);

        // Get all the restauranteList
        restRestauranteMockMvc
            .perform(get(ENTITY_API_URL + "?sort=id,desc"))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(jsonPath("$.[*].id").value(hasItem(restaurante.getId().intValue())))
            .andExpect(jsonPath("$.[*].telefoneRestaurante").value(hasItem(DEFAULT_TELEFONE_RESTAURANTE.intValue())))
            .andExpect(jsonPath("$.[*].emailRestaurante").value(hasItem(DEFAULT_EMAIL_RESTAURANTE)))
            .andExpect(jsonPath("$.[*].ruaRestaurante").value(hasItem(DEFAULT_RUA_RESTAURANTE)))
            .andExpect(jsonPath("$.[*].cepRestaurante").value(hasItem(DEFAULT_CEP_RESTAURANTE.intValue())))
            .andExpect(jsonPath("$.[*].nomeEntregador").value(hasItem(DEFAULT_NOME_ENTREGADOR)))
            .andExpect(jsonPath("$.[*].cnpjRestaurante").value(hasItem(DEFAULT_CNPJ_RESTAURANTE.intValue())))
            .andExpect(jsonPath("$.[*].nomeRestaurante").value(hasItem(DEFAULT_NOME_RESTAURANTE)));
    }

    @Test
    @Transactional
    void getRestaurante() throws Exception {
        // Initialize the database
        restauranteRepository.saveAndFlush(restaurante);

        // Get the restaurante
        restRestauranteMockMvc
            .perform(get(ENTITY_API_URL_ID, restaurante.getId()))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(jsonPath("$.id").value(restaurante.getId().intValue()))
            .andExpect(jsonPath("$.telefoneRestaurante").value(DEFAULT_TELEFONE_RESTAURANTE.intValue()))
            .andExpect(jsonPath("$.emailRestaurante").value(DEFAULT_EMAIL_RESTAURANTE))
            .andExpect(jsonPath("$.ruaRestaurante").value(DEFAULT_RUA_RESTAURANTE))
            .andExpect(jsonPath("$.cepRestaurante").value(DEFAULT_CEP_RESTAURANTE.intValue()))
            .andExpect(jsonPath("$.nomeEntregador").value(DEFAULT_NOME_ENTREGADOR))
            .andExpect(jsonPath("$.cnpjRestaurante").value(DEFAULT_CNPJ_RESTAURANTE.intValue()))
            .andExpect(jsonPath("$.nomeRestaurante").value(DEFAULT_NOME_RESTAURANTE));
    }

    @Test
    @Transactional
    void getNonExistingRestaurante() throws Exception {
        // Get the restaurante
        restRestauranteMockMvc.perform(get(ENTITY_API_URL_ID, Long.MAX_VALUE)).andExpect(status().isNotFound());
    }

    @Test
    @Transactional
    void putNewRestaurante() throws Exception {
        // Initialize the database
        restauranteRepository.saveAndFlush(restaurante);

        int databaseSizeBeforeUpdate = restauranteRepository.findAll().size();

        // Update the restaurante
        Restaurante updatedRestaurante = restauranteRepository.findById(restaurante.getId()).get();
        // Disconnect from session so that the updates on updatedRestaurante are not directly saved in db
        em.detach(updatedRestaurante);
        updatedRestaurante
            .telefoneRestaurante(UPDATED_TELEFONE_RESTAURANTE)
            .emailRestaurante(UPDATED_EMAIL_RESTAURANTE)
            .ruaRestaurante(UPDATED_RUA_RESTAURANTE)
            .cepRestaurante(UPDATED_CEP_RESTAURANTE)
            .nomeEntregador(UPDATED_NOME_ENTREGADOR)
            .cnpjRestaurante(UPDATED_CNPJ_RESTAURANTE)
            .nomeRestaurante(UPDATED_NOME_RESTAURANTE);
        RestauranteDTO restauranteDTO = restauranteMapper.toDto(updatedRestaurante);

        restRestauranteMockMvc
            .perform(
                put(ENTITY_API_URL_ID, restauranteDTO.getId())
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(TestUtil.convertObjectToJsonBytes(restauranteDTO))
            )
            .andExpect(status().isOk());

        // Validate the Restaurante in the database
        List<Restaurante> restauranteList = restauranteRepository.findAll();
        assertThat(restauranteList).hasSize(databaseSizeBeforeUpdate);
        Restaurante testRestaurante = restauranteList.get(restauranteList.size() - 1);
        assertThat(testRestaurante.getTelefoneRestaurante()).isEqualTo(UPDATED_TELEFONE_RESTAURANTE);
        assertThat(testRestaurante.getEmailRestaurante()).isEqualTo(UPDATED_EMAIL_RESTAURANTE);
        assertThat(testRestaurante.getRuaRestaurante()).isEqualTo(UPDATED_RUA_RESTAURANTE);
        assertThat(testRestaurante.getCepRestaurante()).isEqualTo(UPDATED_CEP_RESTAURANTE);
        assertThat(testRestaurante.getNomeEntregador()).isEqualTo(UPDATED_NOME_ENTREGADOR);
        assertThat(testRestaurante.getCnpjRestaurante()).isEqualTo(UPDATED_CNPJ_RESTAURANTE);
        assertThat(testRestaurante.getNomeRestaurante()).isEqualTo(UPDATED_NOME_RESTAURANTE);
    }

    @Test
    @Transactional
    void putNonExistingRestaurante() throws Exception {
        int databaseSizeBeforeUpdate = restauranteRepository.findAll().size();
        restaurante.setId(count.incrementAndGet());

        // Create the Restaurante
        RestauranteDTO restauranteDTO = restauranteMapper.toDto(restaurante);

        // If the entity doesn't have an ID, it will throw BadRequestAlertException
        restRestauranteMockMvc
            .perform(
                put(ENTITY_API_URL_ID, restauranteDTO.getId())
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(TestUtil.convertObjectToJsonBytes(restauranteDTO))
            )
            .andExpect(status().isBadRequest());

        // Validate the Restaurante in the database
        List<Restaurante> restauranteList = restauranteRepository.findAll();
        assertThat(restauranteList).hasSize(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    void putWithIdMismatchRestaurante() throws Exception {
        int databaseSizeBeforeUpdate = restauranteRepository.findAll().size();
        restaurante.setId(count.incrementAndGet());

        // Create the Restaurante
        RestauranteDTO restauranteDTO = restauranteMapper.toDto(restaurante);

        // If url ID doesn't match entity ID, it will throw BadRequestAlertException
        restRestauranteMockMvc
            .perform(
                put(ENTITY_API_URL_ID, count.incrementAndGet())
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(TestUtil.convertObjectToJsonBytes(restauranteDTO))
            )
            .andExpect(status().isBadRequest());

        // Validate the Restaurante in the database
        List<Restaurante> restauranteList = restauranteRepository.findAll();
        assertThat(restauranteList).hasSize(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    void putWithMissingIdPathParamRestaurante() throws Exception {
        int databaseSizeBeforeUpdate = restauranteRepository.findAll().size();
        restaurante.setId(count.incrementAndGet());

        // Create the Restaurante
        RestauranteDTO restauranteDTO = restauranteMapper.toDto(restaurante);

        // If url ID doesn't match entity ID, it will throw BadRequestAlertException
        restRestauranteMockMvc
            .perform(put(ENTITY_API_URL).contentType(MediaType.APPLICATION_JSON).content(TestUtil.convertObjectToJsonBytes(restauranteDTO)))
            .andExpect(status().isMethodNotAllowed());

        // Validate the Restaurante in the database
        List<Restaurante> restauranteList = restauranteRepository.findAll();
        assertThat(restauranteList).hasSize(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    void partialUpdateRestauranteWithPatch() throws Exception {
        // Initialize the database
        restauranteRepository.saveAndFlush(restaurante);

        int databaseSizeBeforeUpdate = restauranteRepository.findAll().size();

        // Update the restaurante using partial update
        Restaurante partialUpdatedRestaurante = new Restaurante();
        partialUpdatedRestaurante.setId(restaurante.getId());

        partialUpdatedRestaurante
            .telefoneRestaurante(UPDATED_TELEFONE_RESTAURANTE)
            .cepRestaurante(UPDATED_CEP_RESTAURANTE)
            .nomeRestaurante(UPDATED_NOME_RESTAURANTE);

        restRestauranteMockMvc
            .perform(
                patch(ENTITY_API_URL_ID, partialUpdatedRestaurante.getId())
                    .contentType("application/merge-patch+json")
                    .content(TestUtil.convertObjectToJsonBytes(partialUpdatedRestaurante))
            )
            .andExpect(status().isOk());

        // Validate the Restaurante in the database
        List<Restaurante> restauranteList = restauranteRepository.findAll();
        assertThat(restauranteList).hasSize(databaseSizeBeforeUpdate);
        Restaurante testRestaurante = restauranteList.get(restauranteList.size() - 1);
        assertThat(testRestaurante.getTelefoneRestaurante()).isEqualTo(UPDATED_TELEFONE_RESTAURANTE);
        assertThat(testRestaurante.getEmailRestaurante()).isEqualTo(DEFAULT_EMAIL_RESTAURANTE);
        assertThat(testRestaurante.getRuaRestaurante()).isEqualTo(DEFAULT_RUA_RESTAURANTE);
        assertThat(testRestaurante.getCepRestaurante()).isEqualTo(UPDATED_CEP_RESTAURANTE);
        assertThat(testRestaurante.getNomeEntregador()).isEqualTo(DEFAULT_NOME_ENTREGADOR);
        assertThat(testRestaurante.getCnpjRestaurante()).isEqualTo(DEFAULT_CNPJ_RESTAURANTE);
        assertThat(testRestaurante.getNomeRestaurante()).isEqualTo(UPDATED_NOME_RESTAURANTE);
    }

    @Test
    @Transactional
    void fullUpdateRestauranteWithPatch() throws Exception {
        // Initialize the database
        restauranteRepository.saveAndFlush(restaurante);

        int databaseSizeBeforeUpdate = restauranteRepository.findAll().size();

        // Update the restaurante using partial update
        Restaurante partialUpdatedRestaurante = new Restaurante();
        partialUpdatedRestaurante.setId(restaurante.getId());

        partialUpdatedRestaurante
            .telefoneRestaurante(UPDATED_TELEFONE_RESTAURANTE)
            .emailRestaurante(UPDATED_EMAIL_RESTAURANTE)
            .ruaRestaurante(UPDATED_RUA_RESTAURANTE)
            .cepRestaurante(UPDATED_CEP_RESTAURANTE)
            .nomeEntregador(UPDATED_NOME_ENTREGADOR)
            .cnpjRestaurante(UPDATED_CNPJ_RESTAURANTE)
            .nomeRestaurante(UPDATED_NOME_RESTAURANTE);

        restRestauranteMockMvc
            .perform(
                patch(ENTITY_API_URL_ID, partialUpdatedRestaurante.getId())
                    .contentType("application/merge-patch+json")
                    .content(TestUtil.convertObjectToJsonBytes(partialUpdatedRestaurante))
            )
            .andExpect(status().isOk());

        // Validate the Restaurante in the database
        List<Restaurante> restauranteList = restauranteRepository.findAll();
        assertThat(restauranteList).hasSize(databaseSizeBeforeUpdate);
        Restaurante testRestaurante = restauranteList.get(restauranteList.size() - 1);
        assertThat(testRestaurante.getTelefoneRestaurante()).isEqualTo(UPDATED_TELEFONE_RESTAURANTE);
        assertThat(testRestaurante.getEmailRestaurante()).isEqualTo(UPDATED_EMAIL_RESTAURANTE);
        assertThat(testRestaurante.getRuaRestaurante()).isEqualTo(UPDATED_RUA_RESTAURANTE);
        assertThat(testRestaurante.getCepRestaurante()).isEqualTo(UPDATED_CEP_RESTAURANTE);
        assertThat(testRestaurante.getNomeEntregador()).isEqualTo(UPDATED_NOME_ENTREGADOR);
        assertThat(testRestaurante.getCnpjRestaurante()).isEqualTo(UPDATED_CNPJ_RESTAURANTE);
        assertThat(testRestaurante.getNomeRestaurante()).isEqualTo(UPDATED_NOME_RESTAURANTE);
    }

    @Test
    @Transactional
    void patchNonExistingRestaurante() throws Exception {
        int databaseSizeBeforeUpdate = restauranteRepository.findAll().size();
        restaurante.setId(count.incrementAndGet());

        // Create the Restaurante
        RestauranteDTO restauranteDTO = restauranteMapper.toDto(restaurante);

        // If the entity doesn't have an ID, it will throw BadRequestAlertException
        restRestauranteMockMvc
            .perform(
                patch(ENTITY_API_URL_ID, restauranteDTO.getId())
                    .contentType("application/merge-patch+json")
                    .content(TestUtil.convertObjectToJsonBytes(restauranteDTO))
            )
            .andExpect(status().isBadRequest());

        // Validate the Restaurante in the database
        List<Restaurante> restauranteList = restauranteRepository.findAll();
        assertThat(restauranteList).hasSize(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    void patchWithIdMismatchRestaurante() throws Exception {
        int databaseSizeBeforeUpdate = restauranteRepository.findAll().size();
        restaurante.setId(count.incrementAndGet());

        // Create the Restaurante
        RestauranteDTO restauranteDTO = restauranteMapper.toDto(restaurante);

        // If url ID doesn't match entity ID, it will throw BadRequestAlertException
        restRestauranteMockMvc
            .perform(
                patch(ENTITY_API_URL_ID, count.incrementAndGet())
                    .contentType("application/merge-patch+json")
                    .content(TestUtil.convertObjectToJsonBytes(restauranteDTO))
            )
            .andExpect(status().isBadRequest());

        // Validate the Restaurante in the database
        List<Restaurante> restauranteList = restauranteRepository.findAll();
        assertThat(restauranteList).hasSize(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    void patchWithMissingIdPathParamRestaurante() throws Exception {
        int databaseSizeBeforeUpdate = restauranteRepository.findAll().size();
        restaurante.setId(count.incrementAndGet());

        // Create the Restaurante
        RestauranteDTO restauranteDTO = restauranteMapper.toDto(restaurante);

        // If url ID doesn't match entity ID, it will throw BadRequestAlertException
        restRestauranteMockMvc
            .perform(
                patch(ENTITY_API_URL).contentType("application/merge-patch+json").content(TestUtil.convertObjectToJsonBytes(restauranteDTO))
            )
            .andExpect(status().isMethodNotAllowed());

        // Validate the Restaurante in the database
        List<Restaurante> restauranteList = restauranteRepository.findAll();
        assertThat(restauranteList).hasSize(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    void deleteRestaurante() throws Exception {
        // Initialize the database
        restauranteRepository.saveAndFlush(restaurante);

        int databaseSizeBeforeDelete = restauranteRepository.findAll().size();

        // Delete the restaurante
        restRestauranteMockMvc
            .perform(delete(ENTITY_API_URL_ID, restaurante.getId()).accept(MediaType.APPLICATION_JSON))
            .andExpect(status().isNoContent());

        // Validate the database contains one less item
        List<Restaurante> restauranteList = restauranteRepository.findAll();
        assertThat(restauranteList).hasSize(databaseSizeBeforeDelete - 1);
    }
}
