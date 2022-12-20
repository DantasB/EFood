package com.xpto.efood.web.rest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.Matchers.hasItem;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import com.xpto.efood.IntegrationTest;
import com.xpto.efood.domain.Pedir;
import com.xpto.efood.repository.PedirRepository;
import com.xpto.efood.service.dto.PedirDTO;
import com.xpto.efood.service.mapper.PedirMapper;
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
 * Integration tests for the {@link PedirResource} REST controller.
 */
@IntegrationTest
@AutoConfigureMockMvc
@WithMockUser
class PedirResourceIT {

    private static final String DEFAULT_NOME_USUARIO = "AAAAAAAAAA";
    private static final String UPDATED_NOME_USUARIO = "BBBBBBBBBB";

    private static final String DEFAULT_ENDERECO_USUARIO = "AAAAAAAAAA";
    private static final String UPDATED_ENDERECO_USUARIO = "BBBBBBBBBB";

    private static final String DEFAULT_EMAIL_USUARIO = "AAAAAAAAAA";
    private static final String UPDATED_EMAIL_USUARIO = "BBBBBBBBBB";

    private static final Long DEFAULT_TELEFONE_USUARIO = 1L;
    private static final Long UPDATED_TELEFONE_USUARIO = 2L;

    private static final Long DEFAULT_CPF_USUARIO = 1L;
    private static final Long UPDATED_CPF_USUARIO = 2L;

    private static final String ENTITY_API_URL = "/api/pedirs";
    private static final String ENTITY_API_URL_ID = ENTITY_API_URL + "/{id}";

    private static Random random = new Random();
    private static AtomicLong count = new AtomicLong(random.nextInt() + (2 * Integer.MAX_VALUE));

    @Autowired
    private PedirRepository pedirRepository;

    @Autowired
    private PedirMapper pedirMapper;

    @Autowired
    private EntityManager em;

    @Autowired
    private MockMvc restPedirMockMvc;

    private Pedir pedir;

    /**
     * Create an entity for this test.
     *
     * This is a static method, as tests for other entities might also need it,
     * if they test an entity which requires the current entity.
     */
    public static Pedir createEntity(EntityManager em) {
        Pedir pedir = new Pedir()
            .nomeUsuario(DEFAULT_NOME_USUARIO)
            .enderecoUsuario(DEFAULT_ENDERECO_USUARIO)
            .emailUsuario(DEFAULT_EMAIL_USUARIO)
            .telefoneUsuario(DEFAULT_TELEFONE_USUARIO)
            .cpfUsuario(DEFAULT_CPF_USUARIO);
        return pedir;
    }

    /**
     * Create an updated entity for this test.
     *
     * This is a static method, as tests for other entities might also need it,
     * if they test an entity which requires the current entity.
     */
    public static Pedir createUpdatedEntity(EntityManager em) {
        Pedir pedir = new Pedir()
            .nomeUsuario(UPDATED_NOME_USUARIO)
            .enderecoUsuario(UPDATED_ENDERECO_USUARIO)
            .emailUsuario(UPDATED_EMAIL_USUARIO)
            .telefoneUsuario(UPDATED_TELEFONE_USUARIO)
            .cpfUsuario(UPDATED_CPF_USUARIO);
        return pedir;
    }

    @BeforeEach
    public void initTest() {
        pedir = createEntity(em);
    }

    @Test
    @Transactional
    void getAllPedirs() throws Exception {
        // Initialize the database
        pedirRepository.saveAndFlush(pedir);

        // Get all the pedirList
        restPedirMockMvc
            .perform(get(ENTITY_API_URL + "?sort=id,desc"))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(jsonPath("$.[*].id").value(hasItem(pedir.getId().intValue())))
            .andExpect(jsonPath("$.[*].nomeUsuario").value(hasItem(DEFAULT_NOME_USUARIO)))
            .andExpect(jsonPath("$.[*].enderecoUsuario").value(hasItem(DEFAULT_ENDERECO_USUARIO)))
            .andExpect(jsonPath("$.[*].emailUsuario").value(hasItem(DEFAULT_EMAIL_USUARIO)))
            .andExpect(jsonPath("$.[*].telefoneUsuario").value(hasItem(DEFAULT_TELEFONE_USUARIO.intValue())))
            .andExpect(jsonPath("$.[*].cpfUsuario").value(hasItem(DEFAULT_CPF_USUARIO.intValue())));
    }

    @Test
    @Transactional
    void getPedir() throws Exception {
        // Initialize the database
        pedirRepository.saveAndFlush(pedir);

        // Get the pedir
        restPedirMockMvc
            .perform(get(ENTITY_API_URL_ID, pedir.getId()))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(jsonPath("$.id").value(pedir.getId().intValue()))
            .andExpect(jsonPath("$.nomeUsuario").value(DEFAULT_NOME_USUARIO))
            .andExpect(jsonPath("$.enderecoUsuario").value(DEFAULT_ENDERECO_USUARIO))
            .andExpect(jsonPath("$.emailUsuario").value(DEFAULT_EMAIL_USUARIO))
            .andExpect(jsonPath("$.telefoneUsuario").value(DEFAULT_TELEFONE_USUARIO.intValue()))
            .andExpect(jsonPath("$.cpfUsuario").value(DEFAULT_CPF_USUARIO.intValue()));
    }

    @Test
    @Transactional
    void getNonExistingPedir() throws Exception {
        // Get the pedir
        restPedirMockMvc.perform(get(ENTITY_API_URL_ID, Long.MAX_VALUE)).andExpect(status().isNotFound());
    }
}
