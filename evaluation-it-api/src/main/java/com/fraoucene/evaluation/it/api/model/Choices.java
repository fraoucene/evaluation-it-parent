package com.fraoucene.evaluation.it.api.model;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by fraoucene on 27/10/2015.
 */

@Entity
@Table(name = "CHOICES", schema = "evaluation_it")
public class Choices implements Serializable {

    private static final long serialVersionUID = 6218803921429517544L;

    public Choices() {
    }

    public Choices(Questions aQuestion,String aChoiceOneCtn, boolean aChoiceOneVal, String aChoiceTwoCtn ,
                   boolean aChoiceTwoVal, String aChoiceThreeCtn ,boolean aChoiceThreeVal, String aChoiceFourCtn ,
                   boolean aChoiceFourVal) {
        this.question = aQuestion;
        this.choiceOneCtn = aChoiceOneCtn;
        this.choiceOneVal = aChoiceOneVal;
        this.choiceTwoCtn = aChoiceTwoCtn;
        this.choiceTwoVal = aChoiceTwoVal;
        this.choiceThreeCtn = aChoiceThreeCtn;
        this.choiceThreeVal = aChoiceThreeVal;
        this.choiceFourCtn = aChoiceFourCtn;
        this.choiceFourVal = aChoiceFourVal;
    }
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "pk_sequence")
    @SequenceGenerator(name = "pk_sequence", sequenceName = "evaluation_it.SEQ_CHOICES")
    @Column(name = "choices_id")
    private Integer choicesId;

    @OneToOne
    @JoinColumn(name = "questions_id", referencedColumnName = "questions_id")
    private Questions question;

    @Column(name = "choice_one_content")
    private String choiceOneCtn;

    @Column(name = "choice_one_value")
    private boolean choiceOneVal;

    @Column(name = "choice_two_content")
    private String choiceTwoCtn;

    @Column(name = "choice_two_value")
    private boolean choiceTwoVal;

    @Column(name = "choice_three_value")
    private boolean choiceThreeVal;

    @Column(name = "choice_three_content")
    private String choiceThreeCtn;

    @Column(name = "choice_four_content")
    private String choiceFourCtn;

    @Column(name = "choice_four_value")
    private boolean choiceFourVal;

    @Override
    public String toString() {
        return "Choices{" +
                "choiceOneCtn='" + choiceOneCtn + '\'' +
                ", choiceOneVal=" + choiceOneVal +
                ", choiceTwoCtn='" + choiceTwoCtn + '\'' +
                ", choiceTwoVal=" + choiceTwoVal +
                ", choiceThreeVal=" + choiceThreeVal +
                ", choiceThreeCtn='" + choiceThreeCtn + '\'' +
                ", choiceFourCtn='" + choiceFourCtn + '\'' +
                ", choiceFourVal=" + choiceFourVal +
                ", choicesId=" + choicesId +
                '}';
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Choices other = (Choices) obj;
        if (getChoicesId() == null) {
            if (other.getChoicesId() != null)
                return false;
        } else if (!getChoicesId().equals(other.getChoicesId()))
            return false;
        return true;
    }

    public Integer getChoicesId() {
        return choicesId;
    }

    public void setChoicesId(Integer choicesId) {
        this.choicesId = choicesId;
    }

    public Questions getQuestion() {
        return question;
    }

    public void setQuestion(Questions question) {
        this.question = question;
    }

    public String getChoiceOneCtn() {
        return choiceOneCtn;
    }

    public void setChoiceOneCtn(String choiceOneCtn) {
        this.choiceOneCtn = choiceOneCtn;
    }

    public boolean isChoiceOneVal() {
        return choiceOneVal;
    }

    public void setChoiceOneVal(boolean choiceOneVal) {
        this.choiceOneVal = choiceOneVal;
    }

    public String getChoiceTwoCtn() {
        return choiceTwoCtn;
    }

    public void setChoiceTwoCtn(String choiceTwoCtn) {
        this.choiceTwoCtn = choiceTwoCtn;
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

    public String getChoiceThreeCtn() {
        return choiceThreeCtn;
    }

    public void setChoiceThreeCtn(String choiceThreeCtn) {
        this.choiceThreeCtn = choiceThreeCtn;
    }

    public String getChoiceFourCtn() {
        return choiceFourCtn;
    }

    public void setChoiceFourCtn(String choiceFourCtn) {
        this.choiceFourCtn = choiceFourCtn;
    }

    public boolean isChoiceFourVal() {
        return choiceFourVal;
    }

    public void setChoiceFourVal(boolean choiceFourVal) {
        this.choiceFourVal = choiceFourVal;
    }
}
