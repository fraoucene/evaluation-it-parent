package com.fraoucene.evaluation.it.api.services;

import com.fraoucene.evaluation.it.api.model.Companies;

/**
 * Created by fraoucene on 05/12/2015.
 */
public interface CompaniesService {

    void createCategory(Companies aCompany);

    boolean isComany(Long id);

    Companies getCompany(Long id);

    Companies getCompnayByName(String aCompanyTitle);

    Iterable<Companies> getAllCompanies();

    void updateCompnay(Companies aCompany);

    void deleteCompany(Long id);
}
