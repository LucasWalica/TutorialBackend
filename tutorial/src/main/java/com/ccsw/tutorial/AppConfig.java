package com.ccsw.tutorial;

import com.ccsw.tutorial.category.model.Category;
import com.ccsw.tutorial.category.model.CategoryDto;
import com.ccsw.tutorial.category.services.CategoryService;
import com.ccsw.tutorial.category.services.CategoryServiceImpl;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class AppConfig {



    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }

    @Bean
    public CategoryService categoryService(){
        return new CategoryServiceImpl() {
            @Override
            public List<CategoryDto> findall() {
                return List.of();
            }
        };
    }
}
