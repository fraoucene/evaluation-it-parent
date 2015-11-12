package com.fraoucene.evaluation.it.api.services;


import com.fraoucene.evaluation.it.api.model.Categories;

/**
 * Created by fraoucene on 27/10/2015.
 */


public interface CategoriesService {

    void createCategory(Categories category);

    boolean isCategory(Integer id);

    Categories getCategory(Integer id);

    Iterable<Categories> getAllCategories();

    void updateCategory(Categories category);

    void deleteCategory(Integer id);

}
