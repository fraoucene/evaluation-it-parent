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
import com.fraoucene.loader.utils.Utils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.Set;

/**
 * Created by fraoucene on 13/11/2015.
 */

public class Loader {

    private static final Logger LOGGER = LoggerFactory.getLogger(Loader.class);

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

    public void load(String jsonName) {
        long loaderStartTime = System.currentTimeMillis();
        QcmData qcmData = null;
        ObjectMapper mapper = new ObjectMapper();
        try {
            LOGGER.info("--- Mapping file [{}]", jsonName);
            qcmData = mapper.readValue(new File(qcmJsonPath+"/"+jsonName), new TypeReference<QcmData>() {
            });
            Set<Qcm> qcmList = qcmData.getQcmList();
            for (Qcm qcm : qcmList) {
                LOGGER.info("");
                LOGGER.info("------------------------------------------------------------------------------------");
                LOGGER.info("--- Creating Question Multi Choice [{}]", qcm.getQcmName());
                LOGGER.info("------------------------------------------------------------------------------------");
                LOGGER.info("");
                saveQcm(qcm);
            }

            String executionTime = Utils.SIMPLE_DATE_FORMAT.format(Utils.durationFrom(loaderStartTime));
            LOGGER.info("--- Ended at [{}] and took [ {} ]", new Date(), executionTime);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void saveQcm(Qcm qcm){
        String categoryName = qcm.getCategoryName();
        Categories category = categoriesService.getCategoryByTitle(categoryName);

        if (category == null){
            category = new Categories(categoryName);
            categoriesService.createCategory(category);
            LOGGER.info("--- Creating Category  [{}]", category.getTitle());
        }else{
            LOGGER.info("--- Category  [{}] Already Exist", category.getTitle());
        }

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
            LOGGER.info("--- Add QCM  [[{}]]  to Category [[{}]]", testQcm.getTitle() ,category.getTitle());
        }
        else {
            LOGGER.info("--- QCM  [{}] Already Exist  in Category [{}]", testQcm.getTitle() ,category.getTitle());
        }
        List<QuestionsJson> questionList = qcm.getQuestionList();
        int questionNumber = 0;
        for (QuestionsJson question : questionList) {
            questionNumber++;
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
                LOGGER.info("--- Add Question Number [{}]  to QCMTest [{}] in Category [{}]", questionNumber, testQcm.getTitle() ,category.getTitle());
            }
            else {
                LOGGER.info("--- Question Number [{}] Already Exist in QCMTest [{}] for the Category [{}]", questionNumber, testQcm.getTitle() ,category.getTitle());
            }
        }
        LOGGER.info("--- Number Question Added = [[{}]]  in QCMTest [[{}]] for the Category [[{}]]", questionList.size(), testQcm.getTitle() ,category.getTitle());
    }
}
