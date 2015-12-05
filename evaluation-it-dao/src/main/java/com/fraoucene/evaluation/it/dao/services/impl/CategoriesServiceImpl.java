package com.fraoucene.evaluation.it.dao.services.impl;

import com.fraoucene.evaluation.it.api.model.Categories;
import com.fraoucene.evaluation.it.api.services.CategoriesService;
import com.fraoucene.evaluation.it.dao.repositories.CategoriesRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by fraoucene on 27/10/2015.
 */

@Service
@Transactional
public class CategoriesServiceImpl implements CategoriesService {
    private static final Logger LOGGER = LoggerFactory.getLogger(CategoriesServiceImpl.class);

    @Autowired
    private CategoriesRepository categoryRepository;

    @Override
    public void createCategory(Categories category) {
        categoryRepository.save(category);
        LOGGER.warn("---- Count Categories records:  {}", categoryRepository.count());

    }

    @Override
    public void createOrUpdateCategory(Categories category) {
        Categories existingCategory = categoryRepository.findByTitle(category.getTitle());
        if (existingCategory == null){
            categoryRepository.save(category);
        }else {
            LOGGER.warn("::::::::::::Categories Already Exist::::::::::::::::::::");
            System.out.print(category.getTitle() + "\n");
            LOGGER.warn("::::::::::::::::::::::::::::::::::::::::::::::::::::::::");
        }
    }

    @Override
    public boolean isCategory(Long id) {
        return categoryRepository.exists(id);
    }


    @Override
    public Categories getCategory(Long id) {
        return categoryRepository.findOne(id);
    }

    @Override
    public Categories getCategoryByTitle(String aCategooryTitle) {
        return  categoryRepository.findByTitle(aCategooryTitle);
    }

    @Override
    public Iterable<Categories> getAllCategories() {
        Iterable<Categories> all = categoryRepository.findAll();
        return all;
    }

    @Override
    public void updateCategory(Categories category) {
        categoryRepository.save(category);
    }

    public void deleteCategory(Long id) {
        categoryRepository.delete(id);
        LOGGER.warn("---- Count Categories records:  {}", categoryRepository.count());
    }
}
