package com.fraoucene.evaluation.it.api.services;

import com.fraoucene.evaluation.it.api.model.Categories;
import com.fraoucene.evaluation.it.api.model.QuestionMultiChoices;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by fraoucene on 27/10/2015.
 */

public interface QuestionMultiChoicesService {

    void addQuestionMultiChoice(QuestionMultiChoices qcm);

    void updateQuestionMultiChoice(QuestionMultiChoices qcm);

    QuestionMultiChoices getQuestionMultiChoices(Integer id);

    Iterable<QuestionMultiChoices> getAllQcm();

    boolean isQcm(Integer id);

    void deleteQuestionMultiChoices(Integer id);

    List<QuestionMultiChoices> getQCMByCategory(Categories category);
}
