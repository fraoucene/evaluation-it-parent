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
    public void createOrUpdateCategory(Categories category) {
        Categories existingCategory = categoryRepository.findByTitle(category.getTitle());
        if (existingCategory == null){
            categoryRepository.save(category);
        }else {
            System.out.print("::::::::::::Categories Already Exist::::::::::::::::::::\n");
            System.out.print(category.getTitle()+"\n");
            System.out.print("::::::::::::::::::::::::::::::::::::::::::::::::::::::::\n");
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

        // And finally count records
        System.out.println("Count Categories records: " + categoryRepository.count());
    }
}
