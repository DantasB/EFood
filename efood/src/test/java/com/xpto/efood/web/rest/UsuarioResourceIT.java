package com.xpto.efood.web.rest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.Matchers.hasItem;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import com.xpto.efood.IntegrationTest;
import com.xpto.efood.domain.Usuario;
import com.xpto.efood.repository.UsuarioRepository;
import com.xpto.efood.service.dto.UsuarioDTO;
import com.xpto.efood.service.mapper.UsuarioMapper;
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
 * Integration tests for the {@link UsuarioResource} REST controller.
 */
@IntegrationTest
@AutoConfigureMockMvc
@WithMockUser
class UsuarioResourceIT {

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

    private static final String ENTITY_API_URL = "/api/usuarios";
    private static final String ENTITY_API_URL_ID = ENTITY_API_URL + "/{id}";

    private static Random random = new Random();
    private static AtomicLong count = new AtomicLong(random.nextInt() + (2 * Integer.MAX_VALUE));

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private UsuarioMapper usuarioMapper;

    @Autowired
    private EntityManager em;

    @Autowired
    private MockMvc restUsuarioMockMvc;

    private Usuario usuario;

    /**
     * Create an entity for this test.
     *
     * This is a static method, as tests for other entities might also need it,
     * if they test an entity which requires the current entity.
     */
    public static Usuario createEntity(EntityManager em) {
        Usuario usuario = new Usuario()
            .nomeUsuario(DEFAULT_NOME_USUARIO)
            .enderecoUsuario(DEFAULT_ENDERECO_USUARIO)
            .emailUsuario(DEFAULT_EMAIL_USUARIO)
            .telefoneUsuario(DEFAULT_TELEFONE_USUARIO)
            .cpfUsuario(DEFAULT_CPF_USUARIO);
        return usuario;
    }

    /**
     * Create an updated entity for this test.
     *
     * This is a static method, as tests for other entities might also need it,
     * if they test an entity which requires the current entity.
     */
    public static Usuario createUpdatedEntity(EntityManager em) {
        Usuario usuario = new Usuario()
            .nomeUsuario(UPDATED_NOME_USUARIO)
            .enderecoUsuario(UPDATED_ENDERECO_USUARIO)
            .emailUsuario(UPDATED_EMAIL_USUARIO)
            .telefoneUsuario(UPDATED_TELEFONE_USUARIO)
            .cpfUsuario(UPDATED_CPF_USUARIO);
        return usuario;
    }

    @BeforeEach
    public void initTest() {
        usuario = createEntity(em);
    }

    @Test
    @Transactional
    void createUsuario() throws Exception {
        int databaseSizeBeforeCreate = usuarioRepository.findAll().size();
        // Create the Usuario
        UsuarioDTO usuarioDTO = usuarioMapper.toDto(usuario);
        restUsuarioMockMvc
            .perform(post(ENTITY_API_URL).contentType(MediaType.APPLICATION_JSON).content(TestUtil.convertObjectToJsonBytes(usuarioDTO)))
            .andExpect(status().isCreated());

        // Validate the Usuario in the database
        List<Usuario> usuarioList = usuarioRepository.findAll();
        assertThat(usuarioList).hasSize(databaseSizeBeforeCreate + 1);
        Usuario testUsuario = usuarioList.get(usuarioList.size() - 1);
        assertThat(testUsuario.getNomeUsuario()).isEqualTo(DEFAULT_NOME_USUARIO);
        assertThat(testUsuario.getEnderecoUsuario()).isEqualTo(DEFAULT_ENDERECO_USUARIO);
        assertThat(testUsuario.getEmailUsuario()).isEqualTo(DEFAULT_EMAIL_USUARIO);
        assertThat(testUsuario.getTelefoneUsuario()).isEqualTo(DEFAULT_TELEFONE_USUARIO);
        assertThat(testUsuario.getCpfUsuario()).isEqualTo(DEFAULT_CPF_USUARIO);
    }

    @Test
    @Transactional
    void createUsuarioWithExistingId() throws Exception {
        // Create the Usuario with an existing ID
        usuario.setId(1L);
        UsuarioDTO usuarioDTO = usuarioMapper.toDto(usuario);

        int databaseSizeBeforeCreate = usuarioRepository.findAll().size();

        // An entity with an existing ID cannot be created, so this API call must fail
        restUsuarioMockMvc
            .perform(post(ENTITY_API_URL).contentType(MediaType.APPLICATION_JSON).content(TestUtil.convertObjectToJsonBytes(usuarioDTO)))
            .andExpect(status().isBadRequest());

        // Validate the Usuario in the database
        List<Usuario> usuarioList = usuarioRepository.findAll();
        assertThat(usuarioList).hasSize(databaseSizeBeforeCreate);
    }

    @Test
    @Transactional
    void checkEnderecoUsuarioIsRequired() throws Exception {
        int databaseSizeBeforeTest = usuarioRepository.findAll().size();
        // set the field null
        usuario.setEnderecoUsuario(null);

        // Create the Usuario, which fails.
        UsuarioDTO usuarioDTO = usuarioMapper.toDto(usuario);

        restUsuarioMockMvc
            .perform(post(ENTITY_API_URL).contentType(MediaType.APPLICATION_JSON).content(TestUtil.convertObjectToJsonBytes(usuarioDTO)))
            .andExpect(status().isBadRequest());

        List<Usuario> usuarioList = usuarioRepository.findAll();
        assertThat(usuarioList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    void checkEmailUsuarioIsRequired() throws Exception {
        int databaseSizeBeforeTest = usuarioRepository.findAll().size();
        // set the field null
        usuario.setEmailUsuario(null);

        // Create the Usuario, which fails.
        UsuarioDTO usuarioDTO = usuarioMapper.toDto(usuario);

        restUsuarioMockMvc
            .perform(post(ENTITY_API_URL).contentType(MediaType.APPLICATION_JSON).content(TestUtil.convertObjectToJsonBytes(usuarioDTO)))
            .andExpect(status().isBadRequest());

        List<Usuario> usuarioList = usuarioRepository.findAll();
        assertThat(usuarioList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    void getAllUsuarios() throws Exception {
        // Initialize the database
        usuarioRepository.saveAndFlush(usuario);

        // Get all the usuarioList
        restUsuarioMockMvc
            .perform(get(ENTITY_API_URL + "?sort=id,desc"))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(jsonPath("$.[*].id").value(hasItem(usuario.getId().intValue())))
            .andExpect(jsonPath("$.[*].nomeUsuario").value(hasItem(DEFAULT_NOME_USUARIO)))
            .andExpect(jsonPath("$.[*].enderecoUsuario").value(hasItem(DEFAULT_ENDERECO_USUARIO)))
            .andExpect(jsonPath("$.[*].emailUsuario").value(hasItem(DEFAULT_EMAIL_USUARIO)))
            .andExpect(jsonPath("$.[*].telefoneUsuario").value(hasItem(DEFAULT_TELEFONE_USUARIO.intValue())))
            .andExpect(jsonPath("$.[*].cpfUsuario").value(hasItem(DEFAULT_CPF_USUARIO.intValue())));
    }

    @Test
    @Transactional
    void getUsuario() throws Exception {
        // Initialize the database
        usuarioRepository.saveAndFlush(usuario);

        // Get the usuario
        restUsuarioMockMvc
            .perform(get(ENTITY_API_URL_ID, usuario.getId()))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(jsonPath("$.id").value(usuario.getId().intValue()))
            .andExpect(jsonPath("$.nomeUsuario").value(DEFAULT_NOME_USUARIO))
            .andExpect(jsonPath("$.enderecoUsuario").value(DEFAULT_ENDERECO_USUARIO))
            .andExpect(jsonPath("$.emailUsuario").value(DEFAULT_EMAIL_USUARIO))
            .andExpect(jsonPath("$.telefoneUsuario").value(DEFAULT_TELEFONE_USUARIO.intValue()))
            .andExpect(jsonPath("$.cpfUsuario").value(DEFAULT_CPF_USUARIO.intValue()));
    }

    @Test
    @Transactional
    void getNonExistingUsuario() throws Exception {
        // Get the usuario
        restUsuarioMockMvc.perform(get(ENTITY_API_URL_ID, Long.MAX_VALUE)).andExpect(status().isNotFound());
    }

    @Test
    @Transactional
    void putNewUsuario() throws Exception {
        // Initialize the database
        usuarioRepository.saveAndFlush(usuario);

        int databaseSizeBeforeUpdate = usuarioRepository.findAll().size();

        // Update the usuario
        Usuario updatedUsuario = usuarioRepository.findById(usuario.getId()).get();
        // Disconnect from session so that the updates on updatedUsuario are not directly saved in db
        em.detach(updatedUsuario);
        updatedUsuario
            .nomeUsuario(UPDATED_NOME_USUARIO)
            .enderecoUsuario(UPDATED_ENDERECO_USUARIO)
            .emailUsuario(UPDATED_EMAIL_USUARIO)
            .telefoneUsuario(UPDATED_TELEFONE_USUARIO)
            .cpfUsuario(UPDATED_CPF_USUARIO);
        UsuarioDTO usuarioDTO = usuarioMapper.toDto(updatedUsuario);

        restUsuarioMockMvc
            .perform(
                put(ENTITY_API_URL_ID, usuarioDTO.getId())
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(TestUtil.convertObjectToJsonBytes(usuarioDTO))
            )
            .andExpect(status().isOk());

        // Validate the Usuario in the database
        List<Usuario> usuarioList = usuarioRepository.findAll();
        assertThat(usuarioList).hasSize(databaseSizeBeforeUpdate);
        Usuario testUsuario = usuarioList.get(usuarioList.size() - 1);
        assertThat(testUsuario.getNomeUsuario()).isEqualTo(UPDATED_NOME_USUARIO);
        assertThat(testUsuario.getEnderecoUsuario()).isEqualTo(UPDATED_ENDERECO_USUARIO);
        assertThat(testUsuario.getEmailUsuario()).isEqualTo(UPDATED_EMAIL_USUARIO);
        assertThat(testUsuario.getTelefoneUsuario()).isEqualTo(UPDATED_TELEFONE_USUARIO);
        assertThat(testUsuario.getCpfUsuario()).isEqualTo(UPDATED_CPF_USUARIO);
    }

    @Test
    @Transactional
    void putNonExistingUsuario() throws Exception {
        int databaseSizeBeforeUpdate = usuarioRepository.findAll().size();
        usuario.setId(count.incrementAndGet());

        // Create the Usuario
        UsuarioDTO usuarioDTO = usuarioMapper.toDto(usuario);

        // If the entity doesn't have an ID, it will throw BadRequestAlertException
        restUsuarioMockMvc
            .perform(
                put(ENTITY_API_URL_ID, usuarioDTO.getId())
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(TestUtil.convertObjectToJsonBytes(usuarioDTO))
            )
            .andExpect(status().isBadRequest());

        // Validate the Usuario in the database
        List<Usuario> usuarioList = usuarioRepository.findAll();
        assertThat(usuarioList).hasSize(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    void putWithIdMismatchUsuario() throws Exception {
        int databaseSizeBeforeUpdate = usuarioRepository.findAll().size();
        usuario.setId(count.incrementAndGet());

        // Create the Usuario
        UsuarioDTO usuarioDTO = usuarioMapper.toDto(usuario);

        // If url ID doesn't match entity ID, it will throw BadRequestAlertException
        restUsuarioMockMvc
            .perform(
                put(ENTITY_API_URL_ID, count.incrementAndGet())
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(TestUtil.convertObjectToJsonBytes(usuarioDTO))
            )
            .andExpect(status().isBadRequest());

        // Validate the Usuario in the database
        List<Usuario> usuarioList = usuarioRepository.findAll();
        assertThat(usuarioList).hasSize(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    void putWithMissingIdPathParamUsuario() throws Exception {
        int databaseSizeBeforeUpdate = usuarioRepository.findAll().size();
        usuario.setId(count.incrementAndGet());

        // Create the Usuario
        UsuarioDTO usuarioDTO = usuarioMapper.toDto(usuario);

        // If url ID doesn't match entity ID, it will throw BadRequestAlertException
        restUsuarioMockMvc
            .perform(put(ENTITY_API_URL).contentType(MediaType.APPLICATION_JSON).content(TestUtil.convertObjectToJsonBytes(usuarioDTO)))
            .andExpect(status().isMethodNotAllowed());

        // Validate the Usuario in the database
        List<Usuario> usuarioList = usuarioRepository.findAll();
        assertThat(usuarioList).hasSize(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    void partialUpdateUsuarioWithPatch() throws Exception {
        // Initialize the database
        usuarioRepository.saveAndFlush(usuario);

        int databaseSizeBeforeUpdate = usuarioRepository.findAll().size();

        // Update the usuario using partial update
        Usuario partialUpdatedUsuario = new Usuario();
        partialUpdatedUsuario.setId(usuario.getId());

        partialUpdatedUsuario
            .nomeUsuario(UPDATED_NOME_USUARIO)
            .emailUsuario(UPDATED_EMAIL_USUARIO)
            .telefoneUsuario(UPDATED_TELEFONE_USUARIO)
            .cpfUsuario(UPDATED_CPF_USUARIO);

        restUsuarioMockMvc
            .perform(
                patch(ENTITY_API_URL_ID, partialUpdatedUsuario.getId())
                    .contentType("application/merge-patch+json")
                    .content(TestUtil.convertObjectToJsonBytes(partialUpdatedUsuario))
            )
            .andExpect(status().isOk());

        // Validate the Usuario in the database
        List<Usuario> usuarioList = usuarioRepository.findAll();
        assertThat(usuarioList).hasSize(databaseSizeBeforeUpdate);
        Usuario testUsuario = usuarioList.get(usuarioList.size() - 1);
        assertThat(testUsuario.getNomeUsuario()).isEqualTo(UPDATED_NOME_USUARIO);
        assertThat(testUsuario.getEnderecoUsuario()).isEqualTo(DEFAULT_ENDERECO_USUARIO);
        assertThat(testUsuario.getEmailUsuario()).isEqualTo(UPDATED_EMAIL_USUARIO);
        assertThat(testUsuario.getTelefoneUsuario()).isEqualTo(UPDATED_TELEFONE_USUARIO);
        assertThat(testUsuario.getCpfUsuario()).isEqualTo(UPDATED_CPF_USUARIO);
    }

    @Test
    @Transactional
    void fullUpdateUsuarioWithPatch() throws Exception {
        // Initialize the database
        usuarioRepository.saveAndFlush(usuario);

        int databaseSizeBeforeUpdate = usuarioRepository.findAll().size();

        // Update the usuario using partial update
        Usuario partialUpdatedUsuario = new Usuario();
        partialUpdatedUsuario.setId(usuario.getId());

        partialUpdatedUsuario
            .nomeUsuario(UPDATED_NOME_USUARIO)
            .enderecoUsuario(UPDATED_ENDERECO_USUARIO)
            .emailUsuario(UPDATED_EMAIL_USUARIO)
            .telefoneUsuario(UPDATED_TELEFONE_USUARIO)
            .cpfUsuario(UPDATED_CPF_USUARIO);

        restUsuarioMockMvc
            .perform(
                patch(ENTITY_API_URL_ID, partialUpdatedUsuario.getId())
                    .contentType("application/merge-patch+json")
                    .content(TestUtil.convertObjectToJsonBytes(partialUpdatedUsuario))
            )
            .andExpect(status().isOk());

        // Validate the Usuario in the database
        List<Usuario> usuarioList = usuarioRepository.findAll();
        assertThat(usuarioList).hasSize(databaseSizeBeforeUpdate);
        Usuario testUsuario = usuarioList.get(usuarioList.size() - 1);
        assertThat(testUsuario.getNomeUsuario()).isEqualTo(UPDATED_NOME_USUARIO);
        assertThat(testUsuario.getEnderecoUsuario()).isEqualTo(UPDATED_ENDERECO_USUARIO);
        assertThat(testUsuario.getEmailUsuario()).isEqualTo(UPDATED_EMAIL_USUARIO);
        assertThat(testUsuario.getTelefoneUsuario()).isEqualTo(UPDATED_TELEFONE_USUARIO);
        assertThat(testUsuario.getCpfUsuario()).isEqualTo(UPDATED_CPF_USUARIO);
    }

    @Test
    @Transactional
    void patchNonExistingUsuario() throws Exception {
        int databaseSizeBeforeUpdate = usuarioRepository.findAll().size();
        usuario.setId(count.incrementAndGet());

        // Create the Usuario
        UsuarioDTO usuarioDTO = usuarioMapper.toDto(usuario);

        // If the entity doesn't have an ID, it will throw BadRequestAlertException
        restUsuarioMockMvc
            .perform(
                patch(ENTITY_API_URL_ID, usuarioDTO.getId())
                    .contentType("application/merge-patch+json")
                    .content(TestUtil.convertObjectToJsonBytes(usuarioDTO))
            )
            .andExpect(status().isBadRequest());

        // Validate the Usuario in the database
        List<Usuario> usuarioList = usuarioRepository.findAll();
        assertThat(usuarioList).hasSize(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    void patchWithIdMismatchUsuario() throws Exception {
        int databaseSizeBeforeUpdate = usuarioRepository.findAll().size();
        usuario.setId(count.incrementAndGet());

        // Create the Usuario
        UsuarioDTO usuarioDTO = usuarioMapper.toDto(usuario);

        // If url ID doesn't match entity ID, it will throw BadRequestAlertException
        restUsuarioMockMvc
            .perform(
                patch(ENTITY_API_URL_ID, count.incrementAndGet())
                    .contentType("application/merge-patch+json")
                    .content(TestUtil.convertObjectToJsonBytes(usuarioDTO))
            )
            .andExpect(status().isBadRequest());

        // Validate the Usuario in the database
        List<Usuario> usuarioList = usuarioRepository.findAll();
        assertThat(usuarioList).hasSize(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    void patchWithMissingIdPathParamUsuario() throws Exception {
        int databaseSizeBeforeUpdate = usuarioRepository.findAll().size();
        usuario.setId(count.incrementAndGet());

        // Create the Usuario
        UsuarioDTO usuarioDTO = usuarioMapper.toDto(usuario);

        // If url ID doesn't match entity ID, it will throw BadRequestAlertException
        restUsuarioMockMvc
            .perform(
                patch(ENTITY_API_URL).contentType("application/merge-patch+json").content(TestUtil.convertObjectToJsonBytes(usuarioDTO))
            )
            .andExpect(status().isMethodNotAllowed());

        // Validate the Usuario in the database
        List<Usuario> usuarioList = usuarioRepository.findAll();
        assertThat(usuarioList).hasSize(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    void deleteUsuario() throws Exception {
        // Initialize the database
        usuarioRepository.saveAndFlush(usuario);

        int databaseSizeBeforeDelete = usuarioRepository.findAll().size();

        // Delete the usuario
        restUsuarioMockMvc
            .perform(delete(ENTITY_API_URL_ID, usuario.getId()).accept(MediaType.APPLICATION_JSON))
            .andExpect(status().isNoContent());

        // Validate the database contains one less item
        List<Usuario> usuarioList = usuarioRepository.findAll();
        assertThat(usuarioList).hasSize(databaseSizeBeforeDelete - 1);
    }
}
