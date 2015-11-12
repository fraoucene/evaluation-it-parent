package com.fraoucene.evaluation.it.api.services;
import com.fraoucene.evaluation.it.api.model.Choices;
import com.fraoucene.evaluation.it.api.model.Questions;
import org.springframework.stereotype.Service;

/**
 * Created by fraoucene on 27/10/2015.
 */
public interface ChoicesService {

    void addChoice(Choices choice);

    void updateChoice(Choices choice);

    Choices getChoice(Integer id);

    Iterable<Choices> getAllChoices();

    Choices getChoiceByQuestionId(Questions question);

    void deleteChoice(Integer id);

}
