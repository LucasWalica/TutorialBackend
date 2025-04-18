package com.ccsw.tutorial.Game.service;


import com.ccsw.tutorial.Author.model.Author;
import com.ccsw.tutorial.Author.service.AuthorService;
import com.ccsw.tutorial.Game.model.GameDto;
import com.ccsw.tutorial.Game.repository.GameRepository;
import com.ccsw.tutorial.Game.model.Game;
import com.ccsw.tutorial.Game.specification.GameSpecification;
import com.ccsw.tutorial.category.model.Category;
import com.ccsw.tutorial.category.services.CategoryService;
import com.ccsw.tutorial.common.criteria.SearchCriteria;
import jakarta.transaction.Transactional;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;


import java.util.List;

/**
 * @author ccsw
 *
 */
@Service
@Transactional
public class GameServiceImpl implements GameService {

    @Autowired
    GameRepository gameRepository;

    @Autowired
    AuthorService authorService;

    @Autowired
    CategoryService categoryService;


    @Override
    public Game getByDto(GameDto dto) {
        return this.gameRepository.findById(dto.getId()).orElse(null);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<Game> find(String title, Long idCategory) {

        GameSpecification titleSpec = new GameSpecification(new SearchCriteria("title", ":", title));
        GameSpecification categorySpec = new GameSpecification(new SearchCriteria("category.id", ":", idCategory));

        Specification<Game> spec = Specification.where(titleSpec).and(categorySpec);

        return this.gameRepository.findAll(spec);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void save(Long id, GameDto dto) {

        Game game;

        if (id == null) {
            game = new Game();
        } else {
            game = this.gameRepository.findById(id).orElse(null);
        }

        BeanUtils.copyProperties(dto, game, "id", "author", "category");


        if(authorService.get(dto.getAuthor().getId()).getClass() == Author.class){
            game.setAuthor(authorService.get(dto.getAuthor().getId()));
        }else {return;}
        if(categoryService.get(dto.getCategory().getId()).getClass() == Category.class){
            game.setCategory(categoryService.get(dto.getCategory().getId()));
        }else {return;}
        this.gameRepository.save(game);
    }

}

