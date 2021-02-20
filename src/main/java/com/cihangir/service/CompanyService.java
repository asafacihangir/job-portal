package com.cihangir.service;

import com.cihangir.model.Company;
import java.util.List;
import org.springframework.transaction.annotation.Transactional;

public interface CompanyService {

  @Transactional
  void saveCompany(Company company);

  Iterable<Company> findAllByUserId(Long userId);

  List<Company> findCompanyByCurrentUser();
}
