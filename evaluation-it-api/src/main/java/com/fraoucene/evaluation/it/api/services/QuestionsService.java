package com.fraoucene.evaluation.it.api.services;

import com.fraoucene.evaluation.it.api.model.QuestionMultiChoices;
import com.fraoucene.evaluation.it.api.model.Questions;

import java.util.List;

/**
 * Created by fraoucene on 27/10/2015.
 */

public interface QuestionsService {

    void addQuestion(Questions question);

    void createOrUpdateQuestion(Questions question);

    void updateQuestion(Questions question);

    Questions getQuestion(Long id);

    Questions getQuestionByContent(String aContent);

    boolean isQuestion(Long id);

    Iterable<Questions> getAllQuestions();

    void deleteQuestion(Long id);

    List<Questions> getQuestionsByQcmId(QuestionMultiChoices qcm);
}
