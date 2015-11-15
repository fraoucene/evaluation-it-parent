package com.fraoucene.loader.helpers;

import com.fraoucene.evaluation.it.api.model.Categories;
import com.fraoucene.evaluation.it.api.model.QuestionMultiChoices;
import com.fraoucene.evaluation.it.api.model.Questions;
import com.fraoucene.evaluation.it.api.services.CategoriesService;
import com.fraoucene.evaluation.it.api.services.QuestionMultiChoicesService;
import com.fraoucene.evaluation.it.api.services.QuestionsService;
import com.fraoucene.loader.model.Qcm;
import com.fraoucene.loader.model.QuestionsJson;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created by fraoucene on 13/11/2015.
 */
public class LoaderHelper {

    @Autowired
    private CategoriesService categoriesService;

    @Autowired
    private QuestionMultiChoicesService questionMultiChoicesService;

    @Autowired
    private QuestionsService questionsService;

    public LoaderHelper() {

    }


    public void saveQcm(Qcm qcm){
        String categoryName = qcm.getCategoryName();
        Categories category = new Categories(categoryName);
        categoriesService.createOrUpdateCategory(category);

        String qcmName = qcm.getQcmName();
        Long duree = qcm.getDuree();
        Long niveau = qcm.getNiveau();
        String langue = qcm.getLangue();
        String descripion = qcm.getDescripion();
        String connaissancesMesurees = qcm.getConnaissancesMesurees();
        String metiersVises = qcm.getMetiersVises();
        QuestionMultiChoices testQcm = new QuestionMultiChoices(category, qcmName, descripion, metiersVises,
                                            connaissancesMesurees, niveau, langue, duree);
        questionMultiChoicesService.createOrUpdateQuestionMultiChoice(testQcm);

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
            //Questions questions = new Questions(testQcm,1, choiceOne, content);
            Questions questions = new Questions(content, testQcm, choiceOne, choiceTwo, choiceThree, choiceFour,
                                                choiceOneValue, choiceTwoValue, choiceThreeValue, choiceFourValue);
            questionsService.createOrUpdateQuestion(questions);

        }
    }

}
