package com.ccsw.tutorial.Game.service;


import com.ccsw.tutorial.Author.model.Author;
import com.ccsw.tutorial.Game.model.Game;
import com.ccsw.tutorial.Game.model.GameDto;

import java.util.List;

/**
 * @author ccsw
 *
 */
public interface GameService {


    Game getByDto(GameDto dto);
    /**
     * Recupera los juegos filtrando opcionalmente por título y/o categoría
     *
     * @param title título del juego
     * @param idCategory PK de la categoría
     * @return {@link List} de {@link Game}
     */
    List<Game> find(String title, Long idCategory);

    /**
     * Guarda o modifica un juego, dependiendo de si el identificador está o no informado
     *
     * @param id PK de la entidad
     * @param dto datos de la entidad
     */
    void save(Long id, GameDto dto);

}