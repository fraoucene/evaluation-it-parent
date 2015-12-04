package com.fraoucene.evaluation.it.api.model;

import com.google.common.base.Predicate;
import com.google.common.collect.Sets;

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
        this.setTitle(title);
    }



    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "pk_sequence")
    @SequenceGenerator(name = "pk_sequence", sequenceName = "evaluation_it.SEQ_CATEGORIES")
    @Column(name = "categories_id")
    private Long categoriesId;

    @OneToMany( mappedBy = "category", cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true)
    private Set<CategoriesQcm> categoriesQcms = new HashSet<>();

    @Column(name = "title")
    private String title;


    public Long getCategoriesId() {
        return categoriesId;
    }

    public void setCategoriesId(Long categoriesId) {
        this.categoriesId = categoriesId;
    }

    public Set<CategoriesQcm> getCategoriesQcms() {
        return categoriesQcms;
    }

    public void setCategoriesQcms(Set<CategoriesQcm> categoriesQcms) {
        this.categoriesQcms = categoriesQcms;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void addQcm(QuestionMultiChoices aQuestionMultiChoices){
        CategoriesQcm categoriesQcm = new CategoriesQcm(this, aQuestionMultiChoices);
        this.categoriesQcms.add(categoriesQcm);
    }

    public void removeQcm(final QuestionMultiChoices aQuestionMultiChoices){
        this.categoriesQcms = Sets.filter(this.categoriesQcms, new Predicate<CategoriesQcm>() {
            @Override
            public boolean apply(CategoriesQcm aCategoriesQcm) {
                return !aCategoriesQcm.getQuestionMultiChoices().equals(aQuestionMultiChoices);
            }
        });
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Categories that = (Categories) o;

        if (categoriesId != null ? !categoriesId.equals(that.categoriesId) : that.categoriesId != null) return false;
        return !(title != null ? !title.equals(that.title) : that.title != null);

    }

    @Override
    public int hashCode() {
        int result = categoriesId != null ? categoriesId.hashCode() : 0;
        result = 31 * result + (title != null ? title.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Categories{" +
                "categoriesId=" + categoriesId +
                ", categoriesQcms=" + categoriesQcms +
                ", title='" + title + '\'' +
                '}';
    }
}
