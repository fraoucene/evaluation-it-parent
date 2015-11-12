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

    public Questions(QuestionMultiChoices qcm, Integer response, String responseContent, String content) {
        this.qcm = qcm;
        this.response = response;
        this.responseContent = responseContent;
        this.content = content;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "pk_sequence")
    @SequenceGenerator(name = "pk_sequence", sequenceName = "evaluation_it.SEQ_QUESTIONS")
    @Column(name = "questions_id")
    private Integer questionsId;// id for uniqueness

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumns({
            @JoinColumn(name = "qcm_id", referencedColumnName = "qcm_id")})
    private QuestionMultiChoices qcm;

    @Column(name = "response")
    private Integer response;

    @Column(name = "response_content")
    private String responseContent;

    @Column(name = "content")
    private String content;

    public QuestionMultiChoices getQcm() {
        return qcm;
    }

    public Integer getQuestionsId() {
        return questionsId;
    }


    public void setQcm(QuestionMultiChoices aQcm) {
        this.qcm = aQcm;
    }

    public Integer getResponse() {
        return response;
    }

    public void setResponse(Integer aResponse) {
        this.response = aResponse;
    }

    public String getResponseContent() {
        return responseContent;
    }

    public void setResponseContent(String aResponseContent) {
        this.responseContent = aResponseContent;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String aContent) {
        this.content = aContent;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Questions questions = (Questions) o;

        if (!questionsId.equals(questions.questionsId)) return false;
        if (!qcm.equals(questions.qcm)) return false;
        if (!response.equals(questions.response)) return false;
        if (!responseContent.equals(questions.responseContent)) return false;
        return content.equals(questions.content);

    }

    @Override
    public int hashCode() {
        int result = questionsId.hashCode();
        result = 31 * result + qcm.hashCode();
        result = 31 * result + response.hashCode();
        result = 31 * result + responseContent.hashCode();
        result = 31 * result + content.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Questions{" +
                "questionsId=" + questionsId +
                ", qcm=" + qcm +
                ", response=" + response +
                ", responseContent='" + responseContent + '\'' +
                ", content='" + content + '\'' +
                '}';
    }
}
