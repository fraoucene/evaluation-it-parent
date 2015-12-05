package com.fraoucene.evaluation.it.dao.services.impl;

import com.fraoucene.evaluation.it.api.model.Companies;
import com.fraoucene.evaluation.it.api.services.CompaniesService;
import com.fraoucene.evaluation.it.dao.repositories.CompaniesRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by fraoucene on 05/12/2015.
 */

@Service
@Transactional
public class CompaniesServiceImpl implements CompaniesService {

    private static final Logger LOGGER = LoggerFactory.getLogger(CompaniesServiceImpl.class);

    @Autowired
    CompaniesRepository companiesRepository;

    @Override
    public void createCategory(Companies aCompany) {
        companiesRepository.save(aCompany);
        LOGGER.warn("---- Count Companies records:  {}", companiesRepository.count());
    }

    @Override
    public boolean isComany(Long id) {
        return companiesRepository.exists(id);
    }

    @Override
    public Companies getCompany(Long id) {
        return companiesRepository.findOne(id);
    }

    @Override
    public Companies getCompnayByName(String aCompanyName) {
        return companiesRepository.findBycompanyName(aCompanyName);
    }

    @Override
    public Iterable<Companies> getAllCompanies() {
        Iterable<Companies> allCompanies = companiesRepository.findAll();
        return allCompanies;
    }

    @Override
    public void updateCompnay(Companies aCompany) {
        Companies company = companiesRepository.findOne(aCompany.getCompanyId());
        companiesRepository.save(company);
    }

    @Override
    public void deleteCompany(Long id) {
        companiesRepository.delete(id);
        LOGGER.warn("---- Count Companies records:  {}", companiesRepository.count());
    }
}
