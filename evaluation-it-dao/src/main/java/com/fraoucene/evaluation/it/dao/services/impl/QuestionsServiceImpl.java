package com.fraoucene.evaluation.it.dao.services.impl;

import com.fraoucene.evaluation.it.api.model.QuestionMultiChoices;
import com.fraoucene.evaluation.it.api.model.Questions;
import com.fraoucene.evaluation.it.api.services.QuestionsService;
import com.fraoucene.evaluation.it.dao.repositories.QuestionsRepository;
import com.google.common.collect.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


/**
 * Created by fraoucene on 27/10/2015.
 */

@Service
@Transactional
public class QuestionsServiceImpl implements QuestionsService {


    @Autowired
    QuestionsRepository questionsRepository;

    @Override
    public void addQuestion(Questions question) {
        questionsRepository.save(question);

        // Count TrackList records
        System.out.println("Count QUESTIONS records: " + questionsRepository.count());
    }

    @Override
    public void updateQuestion(Questions question) {
        questionsRepository.save(question);
    }

    @Override
    public Questions getQuestion(Integer id) {
        return questionsRepository.findOne(id);
    }

    @Override
    public boolean isQuestion(Integer id) {
        return questionsRepository.exists(id);
    }

    @Override
    public Iterable<Questions> getAllQuestions() {
        Iterable<Questions> all = questionsRepository.findAll();
        return all;
    }

    @Override
    public void deleteQuestion(Integer id) {
        questionsRepository.delete(id);

        // Count TrackList records
        System.out.println("Count QUESTIONS records: " + questionsRepository.count());
    }


    @Override
    public List<Questions> getQuestionsByQcmId(QuestionMultiChoices qcm) {
        //return questionsRepository.getQuestionsByQcmId(qcm);
        return null;
    }
}
