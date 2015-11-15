package com.fraoucene.evaluation.it.api.model;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by fraoucene on 27/10/2015.
 */

@Entity
@Table(name = "QUESTIONS", schema = "evaluation_it")
public class Questions implements Serializable {

    private static final long serialVersionUID = 6218803921429517543L;

    public Questions() {
    }

    public Questions(String content, QuestionMultiChoices qcm, String choiceOne, String choiceTwo, String choiceThree,
                     String choiceFour, boolean choiceOneVal, boolean choiceTwoVal, boolean choiceThreeVal,
                     boolean choiceFourVal) {

        this.content = content;
        this.qcm = qcm;
        this.choiceOne = choiceOne;
        this.choiceTwo = choiceTwo;
        this.choiceThree = choiceThree;
        this.choiceFour = choiceFour;
        this.choiceOneVal = choiceOneVal;
        this.choiceTwoVal = choiceTwoVal;
        this.choiceThreeVal = choiceThreeVal;
        this.choiceFourVal = choiceFourVal;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "pk_sequence")
    @SequenceGenerator(name = "pk_sequence", sequenceName = "evaluation_it.SEQ_QUESTIONS")
    @Column(name = "questions_id")
    private Long questionsId;// id for uniqueness

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumns({
            @JoinColumn(name = "qcm_id", referencedColumnName = "qcm_id")})
    private QuestionMultiChoices qcm;


    @Column(name = "content")
    private String content;

    @Column(name = "choice_one")
    private String choiceOne;

    @Column(name = "choice_two")
    private String choiceTwo;

    @Column(name = "choice_three")
    private String choiceThree;

    @Column(name = "choice_four")
    private String choiceFour;

    @Column(name = "choice_one_value")
    private boolean choiceOneVal;

    @Column(name = "choice_two_value")
    private boolean choiceTwoVal;

    @Column(name = "choice_three_value")
    private boolean choiceThreeVal;

    @Column(name = "choice_four_value")
    private boolean choiceFourVal;

    public Long getQuestionsId() {
        return questionsId;
    }

    public void setQuestionsId(Long questionsId) {
        this.questionsId = questionsId;
    }

    public QuestionMultiChoices getQcm() {
        return qcm;
    }

    public void setQcm(QuestionMultiChoices qcm) {
        this.qcm = qcm;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getChoiceOne() {
        return choiceOne;
    }

    public void setChoiceOne(String choiceOne) {
        this.choiceOne = choiceOne;
    }

    public String getChoiceTwo() {
        return choiceTwo;
    }

    public void setChoiceTwo(String choiceTwo) {
        this.choiceTwo = choiceTwo;
    }

    public String getChoiceThree() {
        return choiceThree;
    }

    public void setChoiceThree(String choiceThree) {
        this.choiceThree = choiceThree;
    }

    public String getChoiceFour() {
        return choiceFour;
    }

    public void setChoiceFour(String choiceFour) {
        this.choiceFour = choiceFour;
    }

    public boolean isChoiceOneVal() {
        return choiceOneVal;
    }

    public void setChoiceOneVal(boolean choiceOneVal) {
        this.choiceOneVal = choiceOneVal;
    }

    public boolean isChoiceTwoVal() {
        return choiceTwoVal;
    }

    public void setChoiceTwoVal(boolean choiceTwoVal) {
        this.choiceTwoVal = choiceTwoVal;
    }

    public boolean isChoiceThreeVal() {
        return choiceThreeVal;
    }

    public void setChoiceThreeVal(boolean choiceThreeVal) {
        this.choiceThreeVal = choiceThreeVal;
    }

    public boolean isChoiceFourVal() {
        return choiceFourVal;
    }

    public void setChoiceFourVal(boolean choiceFourVal) {
        this.choiceFourVal = choiceFourVal;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Questions questions = (Questions) o;

        if (!questionsId.equals(questions.questionsId)) return false;
        if (!qcm.equals(questions.qcm)) return false;
        return content.equals(questions.content);

    }

    @Override
    public int hashCode() {
        int result = questionsId.hashCode();
        result = 31 * result + qcm.hashCode();
        result = 31 * result + content.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Questions{" +
                "content='" + content + '\'' +
                ", choiceOne='" + choiceOne + '\'' +
                ", choiceTwo='" + choiceTwo + '\'' +
                ", choiceThree='" + choiceThree + '\'' +
                ", choiceFour='" + choiceFour + '\'' +
                ", choiceOneVal=" + choiceOneVal +
                ", choiceTwoVal=" + choiceTwoVal +
                ", choiceThreeVal=" + choiceThreeVal +
                ", choiceFourVal=" + choiceFourVal +
                ", questionsId=" + questionsId +
                '}';
    }
}
