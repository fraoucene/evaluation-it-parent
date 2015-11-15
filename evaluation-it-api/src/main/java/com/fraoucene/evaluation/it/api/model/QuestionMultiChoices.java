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

    public QuestionMultiChoices(Categories category, String title, String description, String metiersVises,
                                String connaissancesMesurees, Long level, String language,
                                Long duration) {
        this.category = category;
        this.title = title;
        this.description = description;
        this.metiersVises = metiersVises;
        this.connaissancesMesurees = connaissancesMesurees;
        this.level = level;
        this.language = language;
        this.duration = duration;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "pk_sequence")
    @SequenceGenerator(name = "pk_sequence", sequenceName = "evaluation_it.SEQ_QCM")
    @Column(name = "qcm_id")
    private Long questionMultiChoicesId;// id for uniqueness

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumns({
            @JoinColumn(name = "categories_id", referencedColumnName = "categories_id")})
    private Categories category;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "qcm", cascade = CascadeType.ALL)
    private Set<Questions> questions = new HashSet<Questions>(0);

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

    public Long getDuration() {
        return duration;
    }

    public void setDuration(Long duration) {
        this.duration = duration;
    }

    public Long getQuestionMultiChoicesId() {
        return questionMultiChoicesId;
    }

    public void setQuestionMultiChoicesId(Long questionMultiChoicesId) {
        this.questionMultiChoicesId = questionMultiChoicesId;
    }

    public Categories getCategory() {
        return category;
    }

    public void setCategory(Categories category) {
        this.category = category;
    }

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

    public Long getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Long creationDate) {
        this.creationDate = creationDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        QuestionMultiChoices that = (QuestionMultiChoices) o;

        if (!questionMultiChoicesId.equals(that.questionMultiChoicesId)) return false;
        return category.equals(that.category);

    }

    @Override
    public int hashCode() {
        int result = questionMultiChoicesId.hashCode();
        result = 31 * result + category.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "QuestionMultiChoices{" +
                "duration=" + duration +
                ", category=" + category +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", metiersVises='" + metiersVises + '\'' +
                ", connaissancesMesurees='" + connaissancesMesurees + '\'' +
                ", level=" + level +
                ", language='" + language + '\'' +
                ", creationDate=" + creationDate +
                ", questionMultiChoicesId=" + questionMultiChoicesId +
                '}';
    }
}
