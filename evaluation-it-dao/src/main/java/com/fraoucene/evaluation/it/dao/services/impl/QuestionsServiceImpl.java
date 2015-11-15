package com.fraoucene.evaluation.it.dao.services.impl;

import com.fraoucene.evaluation.it.api.model.QuestionMultiChoices;
import com.fraoucene.evaluation.it.api.model.Questions;
import com.fraoucene.evaluation.it.api.services.QuestionsService;
import com.fraoucene.evaluation.it.dao.repositories.QuestionsRepository;
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
    public void createOrUpdateQuestion(Questions question) {
        Questions existingQuestion = questionsRepository.findByContent(question.getContent());
        if (existingQuestion == null) {
            questionsRepository.save(question);
        }else {
            System.out.print(":::::::::::: Questions  Already Exist::::::::::::::::::::\n");
            System.out.print(question.getContent()+"\n");
            System.out.print(":::::::::::::::::::::::::::::::::::::::::::::::::::::::::\n");
        }
    }

    @Override
    public void updateQuestion(Questions question) {
        questionsRepository.save(question);
    }

    @Override
    public Questions getQuestion(Long id) {
        return questionsRepository.findOne(id);
    }

    @Override
    public Questions getQuestionByContent(String aContent) {
        return questionsRepository.findByContent(aContent);
    }

    @Override
    public boolean isQuestion(Long id) {
        return questionsRepository.exists(id);
    }

    @Override
    public Iterable<Questions> getAllQuestions() {
        Iterable<Questions> all = questionsRepository.findAll();
        return all;
    }

    @Override
    public void deleteQuestion(Long id) {
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
