package com.fraoucene.evaluation.it.dao.services.impl;

import com.fraoucene.evaluation.it.api.model.Categories;
import com.fraoucene.evaluation.it.api.services.CategoriesService;
import com.fraoucene.evaluation.it.dao.repositories.CategoriesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by fraoucene on 27/10/2015.
 */

@Service
@Transactional
public class CategoriesServiceImpl implements CategoriesService {

    @Autowired
    CategoriesRepository categoryRepository;


    @Override
    public void createCategory(Categories category) {
        categoryRepository.save(category);

        // Count TrackList records
        System.out.println("Count Categories records: " + categoryRepository.count());

    }

    @Override
    public boolean isCategory(Integer id) {
        return categoryRepository.exists(id);
    }

    @Override
    public Categories getCategory(Integer id) {
        return categoryRepository.findOne(id);
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

    public void deleteCategory(Integer id) {
        categoryRepository.delete(id);

        // And finally count records
        System.out.println("Count Categories records: " + categoryRepository.count());
    }
}
