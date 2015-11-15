package com.fraoucene.evaluation.it.dao.repositories;

import com.fraoucene.evaluation.it.api.model.Categories;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by fraoucene on 27/10/2015.
 * Specificite de spring jpa data
 * Les requetes standards existent deja, il suffit de voir les methodes decrites dans CrudRepository
 * Pour ecrire d'autres requetes il suffit de respecter la convention de nommage ci-dessous
 * getXXXByAttributDelObjetRenvoye
 */

@Repository
public interface CategoriesRepository extends CrudRepository<Categories, Long> {
    Categories findByTitle(String aCategoryTitle);
}
