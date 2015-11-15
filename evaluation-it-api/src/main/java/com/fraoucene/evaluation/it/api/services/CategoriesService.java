package com.fraoucene.evaluation.it.api.services;


import com.fraoucene.evaluation.it.api.model.Categories;

/**
 * Created by fraoucene on 27/10/2015.
 */


public interface CategoriesService {

    void createCategory(Categories category);

    void createOrUpdateCategory(Categories category);

    boolean isCategory(Long id);

    Categories getCategory(Long id);

    Categories getCategoryByTitle(String aCategooryTitle);

    Iterable<Categories> getAllCategories();

    void updateCategory(Categories category);

    void deleteCategory(Long id);

}
