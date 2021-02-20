package com.cihangir.service.impl;

import com.cihangir.dao.CompanyRepository;
import com.cihangir.model.Company;
import com.cihangir.service.CompanyService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
public class SimpleCompanyService implements CompanyService {

  private final CompanyRepository companyRepository;

  public SimpleCompanyService(CompanyRepository companyRepository) {
    this.companyRepository = companyRepository;
  }

  @Transactional
  @Override
  public void saveCompany(Company company){
    companyRepository.save(company);
  }

  @Override
  public Iterable<Company> findAllByUserId(Long userId){
    return companyRepository.findAll();
  }



}
