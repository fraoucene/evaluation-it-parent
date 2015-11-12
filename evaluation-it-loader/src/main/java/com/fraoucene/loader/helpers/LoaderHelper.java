package com.fraoucene.loader.helpers;

import com.fraoucene.evaluation.it.api.model.Categories;
import com.fraoucene.evaluation.it.api.model.Choices;
import com.fraoucene.evaluation.it.api.model.QuestionMultiChoices;
import com.fraoucene.evaluation.it.api.model.Questions;
import com.fraoucene.evaluation.it.api.services.CategoriesService;
import com.fraoucene.evaluation.it.dao.repositories.CategoriesRepository;
import com.fraoucene.loader.model.Qcm;
import com.fraoucene.loader.model.QuestionsJson;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;
import java.util.List;

/**
 * Created by fraoucene on 13/11/2015.
 */
public class LoaderHelper {

public static void saveQcm(Qcm qcm){
    String categoryName = qcm.getCategoryName();
    Categories category = new Categories(categoryName);

    String qcmName = qcm.getQcmName();
    Integer duree = qcm.getDuree();
    Integer niveau = qcm.getNiveau();
    String langue = qcm.getLangue();
    String descripion = qcm.getDescripion();
    String connaissancesMesurees = qcm.getConnaissancesMesurees();
    String metiersVises = qcm.getMetiersVises();
    QuestionMultiChoices testQcm = new QuestionMultiChoices(category, qcmName, descripion, niveau, langue, duree, new Date());

    List<QuestionsJson> questionList = qcm.getQuestionList();
    for (QuestionsJson question : questionList) {
        String content = question.getContent();
        String choiceOne = question.getChoiceOne();
        String choiceTwo = question.getChoiceTwo();
        String choiceThree = question.getChoiceThree();
        String choiceFour = question.getChoiceFour();
        boolean choiceOneValue = question.isChoiceOneValue();
        boolean choiceTwoValue = question.isChoiceTwoValue();
        boolean choiceThreeValue = question.isChoiceThreeValue();
        boolean choiceFourValue = question.isChoiceFourValue();
        Questions questions = new Questions(testQcm,1, choiceOne, content);

        Choices choice = new Choices(questions, choiceOne, choiceOneValue, choiceTwo,choiceTwoValue, choiceThree, choiceThreeValue, choiceFour, choiceFourValue);
    }
}

}
