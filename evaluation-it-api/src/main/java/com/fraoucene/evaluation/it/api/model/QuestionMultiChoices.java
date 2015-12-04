package com.fraoucene.evaluation.it.api.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by fraoucene on 26/10/2015.
 */

@Entity
@Table(name = "QCM", schema = "evaluation_it")
public class QuestionMultiChoices implements Serializable {

    private static final long serialVersionUID = 6218803921429517542L;

    // Spring jpa needs the no-argument constructor to create the table in the database
    public QuestionMultiChoices(){

    }

    public QuestionMultiChoices(String title, String description, String metiersVises, String connaissancesMesurees, Long level, String language, Long duration) {
        this.setTitle(title);
        this.setDescription(description);
        this.setMetiersVises(metiersVises);
        this.setConnaissancesMesurees(connaissancesMesurees);
        this.setLevel(level);
        this.setLanguage(language);
        this.setDuration(duration);
    }

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "pk_sequence")
    @SequenceGenerator(name = "pk_sequence", sequenceName = "evaluation_it.SEQ_QCM")
    @Column(name = "qcm_id")
    private Long questionMultiChoicesId;// id for uniqueness


   // @OneToMany( mappedBy = "questionMultiChoices", cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true)
   // private Set<CategoriesQcm> categoriesQcms = new HashSet<CategoriesQcm>();

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "qcm", cascade = CascadeType.ALL)
    private Set<Questions> questions = new HashSet<>();

    @Column(name = "title")
    private String title;

    @Column(name = "description")
    private String description;

    @Column(name = "metiers_vises")
    private String metiersVises;

    @Column(name = "connaissances_mesurees")
    private String connaissancesMesurees;

    @Column(name = "level")
    private Long level;

    @Column(name = "language")
    private String language;

    @Column(name = "duration")
    private Long duration;

    @Column(name = "creation_date")
    private Long creationDate;


    public Long getQuestionMultiChoicesId() {
        return questionMultiChoicesId;
    }

    public void setQuestionMultiChoicesId(Long questionMultiChoicesId) {
        this.questionMultiChoicesId = questionMultiChoicesId;
    }

    /*
    public Set<CategoriesQcm> getCategoriesQcms() {
        return categoriesQcms;
    }
     */


    //public void setCategoriesQcms(Set<CategoriesQcm> categoriesQcms) {
      //  this.categoriesQcms = categoriesQcms;
    //}

    public Set<Questions> getQuestions() {
        return questions;
    }

    public void setQuestions(Set<Questions> questions) {
        this.questions = questions;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getMetiersVises() {
        return metiersVises;
    }

    public void setMetiersVises(String metiersVises) {
        this.metiersVises = metiersVises;
    }

    public String getConnaissancesMesurees() {
        return connaissancesMesurees;
    }

    public void setConnaissancesMesurees(String connaissancesMesurees) {
        this.connaissancesMesurees = connaissancesMesurees;
    }

    public Long getLevel() {
        return level;
    }

    public void setLevel(Long level) {
        this.level = level;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public Long getDuration() {
        return duration;
    }

    public void setDuration(Long duration) {
        this.duration = duration;
    }

    public Long getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Long creationDate) {
        this.creationDate = creationDate;
    }


 //   public void addToCategory(Categories aCategory){
  //      CategoriesQcm categoriesQcm = new CategoriesQcm(aCategory, this);
  //      this.categoriesQcms.add(categoriesQcm);
  //  }
/*
  public void removeFromCategory(final Categories aCategory){
        this.categoriesQcms = Sets.filter(this.categoriesQcms, new Predicate<CategoriesQcm>() {
            @Override
            public boolean apply(CategoriesQcm aCategoriesQcm) {
                return !aCategoriesQcm.getCategory().equals(aCategory);
            }
        });
    }
 */


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        QuestionMultiChoices that = (QuestionMultiChoices) o;

        if (questionMultiChoicesId != null ? !questionMultiChoicesId.equals(that.questionMultiChoicesId) : that.questionMultiChoicesId != null)
            return false;
        if (title != null ? !title.equals(that.title) : that.title != null) return false;
        if (description != null ? !description.equals(that.description) : that.description != null) return false;
        if (metiersVises != null ? !metiersVises.equals(that.metiersVises) : that.metiersVises != null) return false;
        if (connaissancesMesurees != null ? !connaissancesMesurees.equals(that.connaissancesMesurees) : that.connaissancesMesurees != null)
            return false;
        if (level != null ? !level.equals(that.level) : that.level != null) return false;
        if (language != null ? !language.equals(that.language) : that.language != null) return false;
        if (duration != null ? !duration.equals(that.duration) : that.duration != null) return false;
        return !(creationDate != null ? !creationDate.equals(that.creationDate) : that.creationDate != null);

    }

    @Override
    public int hashCode() {
        int result = questionMultiChoicesId != null ? questionMultiChoicesId.hashCode() : 0;
        result = 31 * result + (title != null ? title.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + (metiersVises != null ? metiersVises.hashCode() : 0);
        result = 31 * result + (connaissancesMesurees != null ? connaissancesMesurees.hashCode() : 0);
        result = 31 * result + (level != null ? level.hashCode() : 0);
        result = 31 * result + (language != null ? language.hashCode() : 0);
        result = 31 * result + (duration != null ? duration.hashCode() : 0);
        result = 31 * result + (creationDate != null ? creationDate.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "QuestionMultiChoices{" +
                "title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", metiersVises='" + metiersVises + '\'' +
                ", connaissancesMesurees='" + connaissancesMesurees + '\'' +
                ", level=" + level +
                ", language='" + language + '\'' +
                ", duration=" + duration +
                ", creationDate=" + creationDate +
                ", questionMultiChoicesId=" + questionMultiChoicesId +
                '}';
    }
}
