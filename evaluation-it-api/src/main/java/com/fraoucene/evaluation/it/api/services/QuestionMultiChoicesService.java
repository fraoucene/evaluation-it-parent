package com.fraoucene.evaluation.it.api.services;

import com.fraoucene.evaluation.it.api.model.Categories;
import com.fraoucene.evaluation.it.api.model.QuestionMultiChoices;

import java.util.List;

/**
 * Created by fraoucene on 27/10/2015.
 */

public interface QuestionMultiChoicesService {

    void addQuestionMultiChoice(QuestionMultiChoices qcm);

    void createOrUpdateQuestionMultiChoice(QuestionMultiChoices qcm);


    void updateQuestionMultiChoice(QuestionMultiChoices qcm);

    QuestionMultiChoices getQuestionMultiChoices(Long id);

    QuestionMultiChoices getQuestionMultiChoicesByTitle(String aQcmTitle);

    Iterable<QuestionMultiChoices> getAllQcm();

    boolean isQcm(Long id);

    void deleteQuestionMultiChoices(Long id);

    List<QuestionMultiChoices> getQCMByCategory(Categories category);
}
