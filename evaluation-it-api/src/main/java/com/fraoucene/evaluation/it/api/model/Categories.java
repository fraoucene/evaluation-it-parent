package com.fraoucene.evaluation.it.api.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by fraoucene on 26/10/2015.
 */
@Entity
@Table(name = "CATEGORIES", schema = "evaluation_it")
public class Categories implements Serializable{
    private static final long serialVersionUID = 6218803921429517541L;

    public Categories(){
    }

    public Categories(String title) {
        this.title = title;
    }


    public Long getCategoriesId() {
        return categoriesId;
    }


    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "pk_sequence")
    @SequenceGenerator(name = "pk_sequence", sequenceName = "evaluation_it.SEQ_CATEGORIES")
    @Column(name = "categories_id")
    private Long categoriesId;// id for uniqueness

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "category", cascade = CascadeType.ALL)
    private Set<QuestionMultiChoices> questionMultiChoices = new HashSet<QuestionMultiChoices>(0);

    @Column(name = "title")
    private String title;// tracklist's title

    public String getTitle() {
        return title;
    }


    public void setTitle(String aTitle) {
        this.title = aTitle;
    }

    public Set<QuestionMultiChoices> getQcms() {
        return this.questionMultiChoices;
    }

    public void setQcms(Set<QuestionMultiChoices> aQuestionMultiChoices) {
        this.questionMultiChoices = aQuestionMultiChoices;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Categories that = (Categories) o;

        if (!categoriesId.equals(that.categoriesId)) return false;
        if (!questionMultiChoices.equals(that.questionMultiChoices)) return false;
        return title.equals(that.title);

    }

    @Override
    public int hashCode() {
        int result = categoriesId.hashCode();
        result = 31 * result + questionMultiChoices.hashCode();
        result = 31 * result + title.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Categories{" +
                "categoriesId=" + categoriesId +
                ", questionMultiChoices=" + questionMultiChoices +
                ", title='" + title + '\'' +
                '}';
    }
}
