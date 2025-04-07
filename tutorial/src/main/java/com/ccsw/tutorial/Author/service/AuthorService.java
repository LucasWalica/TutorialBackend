package com.ccsw.tutorial.Author.service;

import com.ccsw.tutorial.Author.model.Author;
import com.ccsw.tutorial.Author.model.AuthorDTO;
import com.ccsw.tutorial.Author.model.AuthorSearchDto;
import org.springframework.data.domain.Page;

import java.util.List;

public interface AuthorService {
    /**
     * Recupera un listado de autores {@link Author}
     *
     * @return {@link List} de {@link Author}
     */
    List<Author> findAll();

    /**
     * Recupera un {@link Author} a través de su ID
     *
     * @param id PK de la entidad
     * @return {@link Author}
     */
    Author get(Long id);
    /**
     * Método para recuperar un listado paginado de {@link Author}
     *
     * @param dto dto de búsqueda
     * @return {@link Page} de {@link Author}
     */
    Page<Author> findPage(AuthorSearchDto dto);

    /**
     * Método para crear o actualizar un {@link Author}
     *
     * @param id PK de la entidad
     * @param dto datos de la entidad
     */
    void save(Long id, AuthorDTO dto);

    /**
     * Método para crear o actualizar un {@link Author}
     *
     * @param id PK de la entidad
     */
    void delete(Long id) throws Exception;

}