package com.fraoucene.evaluation.it.api.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
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

    public QuestionMultiChoices(Categories aCategory, String aTitle, String aDescription, Integer aLevel,
                                String aLanguage, Integer aDuration, Date aCreationDate) {
        this.category = aCategory;
        this.title = aTitle;
        this.description = aDescription;
        this.level = aLevel;
        this.language = aLanguage;
        this.duration = aDuration;
        this.creationDate = aCreationDate;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "pk_sequence")
    @SequenceGenerator(name = "pk_sequence", sequenceName = "evaluation_it.SEQ_QCM")
    @Column(name = "qcm_id")
    private Integer questionMultiChoicesId;// id for uniqueness

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumns({
            @JoinColumn(name = "categories_id", referencedColumnName = "categories_id")})
    private Categories category;



    @Column(name = "title")
    private String title;

    @Column(name = "description")
    private String description;

    @Column(name = "level")
    private Integer level;

    @Column(name = "language")
    private String language;

    @Column(name = "duration")
    private Integer duration;

    @Column(name = "creation_date")
    private Date creationDate;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "qcm", cascade = CascadeType.ALL)
    private Set<Questions> questions = new HashSet<Questions>(0);

    public Set<Questions> getQuestions() {
        return questions;
    }

    public void setQuestions(Set<Questions> aQuestions) {
        this.questions = aQuestions;
    }

    public void setCategory(Categories aCategory) {
        this.category = aCategory;
    }

    public Categories getCategory() {
        return category;
    }

    public Integer getQuestionMultiChoicesId() {
        return questionMultiChoicesId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String aTitle) {
        this.title = aTitle;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String aDescription) {
        this.description = aDescription;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer aLevel) {
        this.level = aLevel;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String aLanguage) {
        this.language = aLanguage;
    }

    public Integer getDuration() {
        return duration;
    }

    public void setDuration(Integer aDuration) {
        this.duration = aDuration;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date aCreationDate) {
        this.creationDate = aCreationDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        QuestionMultiChoices that = (QuestionMultiChoices) o;

        if (!questionMultiChoicesId.equals(that.questionMultiChoicesId)) return false;
        if (!category.equals(that.category)) return false;
        if (!title.equals(that.title)) return false;
        if (!description.equals(that.description)) return false;
        if (!level.equals(that.level)) return false;
        if (!language.equals(that.language)) return false;
        if (!duration.equals(that.duration)) return false;
        if (!creationDate.equals(that.creationDate)) return false;
        return questions.equals(that.questions);

    }

    @Override
    public int hashCode() {
        int result = questionMultiChoicesId.hashCode();
        result = 31 * result + category.hashCode();
        result = 31 * result + title.hashCode();
        result = 31 * result + description.hashCode();
        result = 31 * result + level.hashCode();
        result = 31 * result + language.hashCode();
        result = 31 * result + duration.hashCode();
        result = 31 * result + creationDate.hashCode();
        result = 31 * result + questions.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "QuestionMultiChoices{" +
                "questionMultiChoicesId=" + questionMultiChoicesId +
                ", category=" + category +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", level=" + level +
                ", language='" + language + '\'' +
                ", duration=" + duration +
                ", creationDate=" + creationDate +
                ", questions=" + questions +
                '}';
    }
}
