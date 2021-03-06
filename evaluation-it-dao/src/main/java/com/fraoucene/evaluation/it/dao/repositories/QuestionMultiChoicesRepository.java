package com.fraoucene.evaluation.it.dao.repositories;


import com.fraoucene.evaluation.it.api.model.Categories;
import com.fraoucene.evaluation.it.api.model.QuestionMultiChoices;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by fraoucene on 27/10/2015.
 */


@Repository
public interface QuestionMultiChoicesRepository extends CrudRepository<QuestionMultiChoices,Integer> {
    List<QuestionMultiChoices> getQuestionMultiChoicesByCategory(Categories category);
}
