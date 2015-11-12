package com.fraoucene.loader.model;

import com.fasterxml.jackson.annotation.JsonCreator;

import java.util.Set;

/**
 * Created by fraoucene on 12/11/2015.
 */
public class QcmData {

    private final Set<Qcm> qcmList;

    @JsonCreator
    public QcmData(Set<Qcm> aQcmList) {
        this.qcmList = aQcmList;
    }

    public Set<Qcm> getQcmList() {
        return qcmList;
    }
}
