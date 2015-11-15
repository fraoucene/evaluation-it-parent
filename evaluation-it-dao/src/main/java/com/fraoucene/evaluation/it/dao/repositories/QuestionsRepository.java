package com.fraoucene.evaluation.it.dao.repositories;


import com.fraoucene.evaluation.it.api.model.Questions;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by fraoucene on 27/10/2015.
 */

@Repository
public interface QuestionsRepository extends CrudRepository<Questions, Long> {
   // List<Questions> getQuestionsByQcmId(QuestionMultiChoices qcm);
   Questions findByContent(String aQuestionTitle);
}
