package com.fraoucene.evaluation.it.dao.repositories;

import com.fraoucene.evaluation.it.api.model.Choices;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by fraoucene on 27/10/2015.
 */

@Repository
public interface ChoicesRepository extends CrudRepository<Choices, Integer> {
}
