package com.ccsw.category.services;



import com.ccsw.category.model.Category;
import com.ccsw.category.model.CategoryDto;

import java.util.List;
public interface CategoryService {


    /**
     * Recupera una {@link Category} a partir de su ID
     *
     * @param id PK de la entidad
     * @return {@link Category}
     */
    Category get(Long id);

    List<CategoryDto> findall();

    List<Category> findAll();

    void save(Long id, CategoryDto dto);

    void delete(Long id) throws Exception;
}
