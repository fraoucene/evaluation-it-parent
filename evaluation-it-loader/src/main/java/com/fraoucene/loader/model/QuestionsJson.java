package com.fraoucene.loader.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by fraoucene on 12/11/2015.
 */
public class QuestionsJson implements Comparable  {


    private final String content;
    private final String choiceOne;
    private final String choiceTwo;
    private final String choiceThree;
    private final String choiceFour;
    private final boolean choiceOneValue;
    private final boolean choiceTwoValue;
    private final boolean choiceThreeValue;
    private final boolean choiceFourValue;

    public QuestionsJson(boolean choiceTwoValue, String content, String choiceOne, String choiceTwo,
                         String choiceThree, String choiceFour, boolean choiceOneValue,
                         boolean choiceThreeValue, boolean choiceFourValue) {
        this.choiceTwoValue = choiceTwoValue;
        this.content = content;
        this.choiceOne = choiceOne;
        this.choiceTwo = choiceTwo;
        this.choiceThree = choiceThree;
        this.choiceFour = choiceFour;
        this.choiceOneValue = choiceOneValue;
        this.choiceThreeValue = choiceThreeValue;
        this.choiceFourValue = choiceFourValue;
    }

    @JsonCreator
    public QuestionsJson(@JsonProperty("content") String aContent,
                         @JsonProperty("choice_one") String aChoiceOne,
                         @JsonProperty("choice_two") String aChoiceTwo,
                         @JsonProperty("choice_three") String aChoiceThree,
                         @JsonProperty("choice_four") String aChoiceFour,
                         @JsonProperty("choice_one_value") boolean aChoiceOneValue,
                         @JsonProperty("choice_two_value") boolean aChoiceTwoValue,
                         @JsonProperty("choice_three_value") boolean aChoiceThreeValue,
                         @JsonProperty("choice_four_value") boolean aChoiceFourValue) {

        this.content = aContent;
        this.choiceOne = aChoiceOne;
        this.choiceTwo = aChoiceTwo;
        this.choiceThree = aChoiceThree;
        this.choiceFour = aChoiceFour;
        this.choiceOneValue = aChoiceOneValue;
        this.choiceTwoValue = aChoiceTwoValue;
        this.choiceThreeValue = aChoiceThreeValue;
        this.choiceFourValue = aChoiceFourValue;

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        QuestionsJson questions = (QuestionsJson) o;

        if (!content.equals(questions.content)) return false;
        if (!choiceOne.equals(questions.choiceOne)) return false;
        if (!choiceTwo.equals(questions.choiceTwo)) return false;
        if (!choiceThree.equals(questions.choiceThree)) return false;
        return choiceFour.equals(questions.choiceFour);

    }

    @Override
    public int compareTo(Object o) {
        return 0;
    }


    @Override
    public int hashCode() {
        return content.hashCode();
    }

    public String getContent() {
        return content;
    }

    public String getChoiceOne() {
        return choiceOne;
    }

    public String getChoiceTwo() {
        return choiceTwo;
    }

    public String getChoiceThree() {
        return choiceThree;
    }

    public String getChoiceFour() {
        return choiceFour;
    }

    public boolean isChoiceOneValue() {
        return choiceOneValue;
    }

    public boolean isChoiceTwoValue() {
        return choiceTwoValue;
    }

    public boolean isChoiceThreeValue() {
        return choiceThreeValue;
    }

    public boolean isChoiceFourValue() {
        return choiceFourValue;
    }
}
