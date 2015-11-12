package com.fraoucene.evaluation.it.api.services;

import com.fraoucene.evaluation.it.api.model.QuestionMultiChoices;
import com.fraoucene.evaluation.it.api.model.Questions;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by fraoucene on 27/10/2015.
 */

public interface QuestionsService {

    void addQuestion(Questions question);

    void updateQuestion(Questions question);

    Questions getQuestion(Integer id);

    boolean isQuestion(Integer id);

    Iterable<Questions> getAllQuestions();

    void deleteQuestion(Integer id);

    List<Questions> getQuestionsByQcmId(QuestionMultiChoices qcm);
}
