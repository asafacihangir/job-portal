package com.cihangir.service;

import com.cihangir.model.Company;
import java.util.List;

import com.cihangir.model.JobNotice;
import org.springframework.transaction.annotation.Transactional;

public interface CompanyService {

  @Transactional
  void saveCompany(Company company);

  Iterable<Company> findAllByUserId(Long userId);

  List<Company> findCompanyByCurrentUser();

  public void updateCompany(Company company);

  public Company findOne(Long theId);
}
