package com.fraoucene.evaluation.it.api.model;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by fraoucene on 21/11/2015.
 */

@Entity
@Table(name = "CATEGORIES_QCM", schema = "evaluation_it")
public class CategoriesQcm implements Serializable {
    @Id
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "categories_id")
    private Categories category;

    @Id
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "qcm_id")
    private QuestionMultiChoices questionMultiChoices;

    public CategoriesQcm(){

    }

    public CategoriesQcm(Categories category, QuestionMultiChoices questionMultiChoices) {
        this.category = category;
        this.questionMultiChoices = questionMultiChoices;
    }

    public Categories getCategory() {
        return category;
    }

    public void setCategory(Categories category) {
        this.category = category;
    }




    public QuestionMultiChoices getQuestionMultiChoices() {
        return questionMultiChoices;
    }

    public void setQuestionMultiChoices(QuestionMultiChoices questionMultiChoices) {
        this.questionMultiChoices = questionMultiChoices;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CategoriesQcm that = (CategoriesQcm) o;

        if (category != null ? !category.equals(that.category) : that.category != null) return false;
        return !(questionMultiChoices != null ? !questionMultiChoices.equals(that.questionMultiChoices) : that.questionMultiChoices != null);

    }

    @Override
    public int hashCode() {
        int result = category != null ? category.hashCode() : 0;
        result = 31 * result + (questionMultiChoices != null ? questionMultiChoices.hashCode() : 0);
        return result;
    }
}
