package com.fraoucene.loader.main;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fraoucene.evaluation.it.api.model.Categories;
import com.fraoucene.evaluation.it.api.model.QuestionMultiChoices;
import com.fraoucene.evaluation.it.api.model.Questions;
import com.fraoucene.evaluation.it.api.services.CategoriesService;
import com.fraoucene.evaluation.it.api.services.QuestionMultiChoicesService;
import com.fraoucene.evaluation.it.api.services.QuestionsService;
import com.fraoucene.loader.model.Qcm;
import com.fraoucene.loader.model.QcmData;
import com.fraoucene.loader.model.QuestionsJson;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Set;

/**
 * Created by fraoucene on 13/11/2015.
 */

public class Loader {

    @Autowired
    private CategoriesService categoriesService;

    @Autowired
    private QuestionMultiChoicesService questionMultiChoicesService;

    @Autowired
    private QuestionsService questionsService;

    private final String qcmJsonPath;

    public Loader(String qcmJsonPath) {
        this.qcmJsonPath = qcmJsonPath;

    }

    public void load() {

        QcmData qcmData = null;
        ObjectMapper mapper = new ObjectMapper();
        try {
            qcmData = mapper.readValue(new File(qcmJsonPath), new TypeReference<QcmData>() {
            });
            Set<Qcm> qcmList = qcmData.getQcmList();
            for (Qcm qcm : qcmList) {
                saveQcm(qcm);
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void saveQcm(Qcm qcm){
        String categoryName = qcm.getCategoryName();
        Categories category = categoriesService.getCategoryByTitle(categoryName);
        //Categories category = new Categories(categoryName);
        if (category == null){
            category = new Categories(categoryName);
            categoriesService.createCategory(category);
        }
        //categoriesService.createOrUpdateCategory(category);



        String qcmName = qcm.getQcmName();
        Long duree = qcm.getDuree();
        Long niveau = qcm.getNiveau();
        String langue = qcm.getLangue();
        String descripion = qcm.getDescripion();
        String connaissancesMesurees = qcm.getConnaissancesMesurees();
        String metiersVises = qcm.getMetiersVises();

        QuestionMultiChoices testQcm = questionMultiChoicesService.getQuestionMultiChoicesByTitle(qcmName);
        if (testQcm == null){
            testQcm = new QuestionMultiChoices(category, qcmName, descripion, metiersVises,
                    connaissancesMesurees, niveau, langue, duree);
            testQcm.setCreationDate(System.currentTimeMillis());
            questionMultiChoicesService.addQuestionMultiChoice(testQcm);
        }

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
            Questions questions = questionsService.getQuestionByContent(content);
            if (questions == null){
                questions = new Questions(content, testQcm, choiceOne, choiceTwo, choiceThree, choiceFour,
                        choiceOneValue, choiceTwoValue, choiceThreeValue, choiceFourValue);
                questionsService.addQuestion(questions);
            }

        }
    }
}
