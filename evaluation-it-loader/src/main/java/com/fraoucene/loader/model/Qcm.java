package com.fraoucene.loader.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

/**
 * Created by fraoucene on 12/11/2015.
 */
public class Qcm implements Comparable  {

    private final String categoryName;
    private final String qcmName;
    private final Long duree;
    private final Long niveau;
    private final String langue;
    private final String descripion;
    private final String connaissancesMesurees;
    private final String metiersVises;
    private final List<QuestionsJson> questionList;

    public Qcm(String name, Long duree, Long niveau, String langue, String descripion,
               String category, String connaissancesMesurees1, String metiersVises1, List<QuestionsJson> aQuestionList) {
        this.qcmName = name;
        this.duree = duree;
        this.niveau = niveau;
        this.langue = langue;
        this.descripion = descripion;
        this.categoryName = category;
        this.connaissancesMesurees = connaissancesMesurees1;
        this.metiersVises = metiersVises1;
        this.questionList = aQuestionList;
    }

    @JsonCreator
    public Qcm(@JsonProperty("category_name") String aCategoryName,
                        @JsonProperty("qcm_name") String aQcmName,
                        @JsonProperty("duree") Long aDuree,
                        @JsonProperty("niveau") Long aNiveau,
                        @JsonProperty("langue") String aLangue,
                        @JsonProperty("description") String aDescripion,
                        @JsonProperty("connaissances_mesurees") String  aConnaissancesMesurees,
                        @JsonProperty("metiers_vises") String aMetiersVises,
                        @JsonProperty("questions") List<QuestionsJson> aQuestionList) {
        this.categoryName = aCategoryName;
        this.qcmName = aQcmName;
        this.duree = aDuree;
        this.niveau = aNiveau;
        this.langue = aLangue;
        this.descripion = aDescripion;
        this.connaissancesMesurees = aConnaissancesMesurees;
        this.metiersVises = aMetiersVises;
        this.questionList = aQuestionList;
    }


    @Override
    public int compareTo(Object o) {
        return 0;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public String getQcmName() {
        return qcmName;
    }

    public Long getDuree() {
        return duree;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Qcm qcm = (Qcm) o;

        if (categoryName != null ? !categoryName.equals(qcm.categoryName) : qcm.categoryName != null) return false;
        if (qcmName != null ? !qcmName.equals(qcm.qcmName) : qcm.qcmName != null) return false;
        if (duree != null ? !duree.equals(qcm.duree) : qcm.duree != null) return false;
        if (niveau != null ? !niveau.equals(qcm.niveau) : qcm.niveau != null) return false;
        if (langue != null ? !langue.equals(qcm.langue) : qcm.langue != null) return false;
        if (descripion != null ? !descripion.equals(qcm.descripion) : qcm.descripion != null) return false;
        if (connaissancesMesurees != null ? !connaissancesMesurees.equals(qcm.connaissancesMesurees) : qcm.connaissancesMesurees != null)
            return false;
        if (metiersVises != null ? !metiersVises.equals(qcm.metiersVises) : qcm.metiersVises != null) return false;
        return !(questionList != null ? !questionList.equals(qcm.questionList) : qcm.questionList != null);

    }

    @Override
    public int hashCode() {
        int result = categoryName != null ? categoryName.hashCode() : 0;
        result = 31 * result + (qcmName != null ? qcmName.hashCode() : 0);
        result = 31 * result + (duree != null ? duree.hashCode() : 0);
        result = 31 * result + (niveau != null ? niveau.hashCode() : 0);
        result = 31 * result + (langue != null ? langue.hashCode() : 0);
        result = 31 * result + (descripion != null ? descripion.hashCode() : 0);
        result = 31 * result + (connaissancesMesurees != null ? connaissancesMesurees.hashCode() : 0);
        result = 31 * result + (metiersVises != null ? metiersVises.hashCode() : 0);
        result = 31 * result + (questionList != null ? questionList.hashCode() : 0);
        return result;
    }

    public Long getNiveau() {

        return niveau;
    }

    public String getLangue() {
        return langue;
    }

    public String getDescripion() {
        return descripion;
    }

    public String getConnaissancesMesurees() {
        return connaissancesMesurees;
    }

    public String getMetiersVises() {
        return metiersVises;
    }

    public List<QuestionsJson> getQuestionList() {
        return questionList;
    }
}
