package com.fraoucene.evaluation.it.dao.services.impl;

import com.fraoucene.evaluation.it.api.model.Choices;
import com.fraoucene.evaluation.it.api.model.Questions;
import com.fraoucene.evaluation.it.api.services.ChoicesService;
import com.fraoucene.evaluation.it.dao.repositories.ChoicesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by fraoucene on 27/10/2015.
 */

@Service
@Transactional
public class ChoicesServiceImpl implements ChoicesService {

    @Autowired
    ChoicesRepository choicesRepository;

    @Override
    public void addChoice(Choices choice) {
        choicesRepository.save(choice);

        // Count TrackList records
        System.out.println("Count Choice records: " + choicesRepository.count());
    }

    @Override
    public void updateChoice(Choices choice) {
        choicesRepository.save(choice);
    }

    @Override
    public Choices getChoice(Integer id) {
        return choicesRepository.findOne(id);
    }

    @Override
    public Iterable<Choices> getAllChoices() {
        Iterable<Choices> all = choicesRepository.findAll();
        return all;
    }

    @Override
    public Choices getChoiceByQuestionId(Questions question) {
        //TODO
        return null;
    }

    @Override
    public void deleteChoice(Integer id) {
        choicesRepository.delete(id);

        // Count TrackList records
        System.out.println("Count Choice records: " + choicesRepository.count());
    }
}
