package com.fraoucene.evaluation.it.dao.services.impl;

import com.fraoucene.evaluation.it.api.model.Categories;
import com.fraoucene.evaluation.it.api.model.QuestionMultiChoices;
import com.fraoucene.evaluation.it.api.services.QuestionMultiChoicesService;
import com.fraoucene.evaluation.it.dao.repositories.QuestionMultiChoicesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by fraoucene on 27/10/2015.
 */

@Service
@Transactional
public class QuestionMultiChoicesServiceImpl implements QuestionMultiChoicesService {

    @Autowired
    QuestionMultiChoicesRepository questionMultiChoicesRepository;

    @Override
    public void addQuestionMultiChoice(QuestionMultiChoices qcm) {
        questionMultiChoicesRepository.save(qcm);

        // Count TrackList records
        System.out.println("Count QCM records: " + questionMultiChoicesRepository.count());
    }

    @Override
    public void updateQuestionMultiChoice(QuestionMultiChoices qcm) {
        questionMultiChoicesRepository.save(qcm);

    }

    @Override
    public QuestionMultiChoices getQuestionMultiChoices(Integer id) {
        return questionMultiChoicesRepository.findOne(id);
    }

    @Override
    public Iterable<QuestionMultiChoices> getAllQcm() {
        Iterable<QuestionMultiChoices> all = questionMultiChoicesRepository.findAll();
        return all;
    }

    @Override
    public boolean isQcm(Integer id) {
        return questionMultiChoicesRepository.exists(id);
    }

    @Override
    public void deleteQuestionMultiChoices(Integer id) {
        questionMultiChoicesRepository.delete(id);

        // Count TrackList records
        System.out.println("Count QCM records: " + questionMultiChoicesRepository.count());
    }

    @Override
    public List<QuestionMultiChoices> getQCMByCategory(Categories category) {
        return  questionMultiChoicesRepository.getQuestionMultiChoicesByCategory(category);
    }
}
