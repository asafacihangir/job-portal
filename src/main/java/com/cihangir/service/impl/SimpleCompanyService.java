package com.cihangir.service.impl;

import com.cihangir.dao.CompanyRepository;
import com.cihangir.enums.UserType;
import com.cihangir.model.Company;
import com.cihangir.model.User;
import com.cihangir.security.UserService;
import com.cihangir.service.CompanyService;
import java.util.Collections;
import java.util.List;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
public class SimpleCompanyService implements CompanyService {

  private final CompanyRepository companyRepository;
  private final UserService userService;

  public SimpleCompanyService(CompanyRepository companyRepository,
      UserService userService) {
    this.companyRepository = companyRepository;
    this.userService = userService;
  }

  @Transactional
  @Override
  public void saveCompany(Company company) {
    companyRepository.save(company);
  }

  @Override
  public Iterable<Company> findAllByUserId(Long userId) {
    return companyRepository.findAllByUserId(userId);
  }

  @Override
  public List<Company> findCompanyByCurrentUser() {

    User currentUser = userService.getCurrentUser();

    if (UserType.ADMIN.equals(currentUser.getUserType())) {
      return companyRepository.findAll();
    } else if (UserType.COMPANY_USER.equals(currentUser.getUserType())) {
      return companyRepository.findAllByUserId(currentUser.getId());
    } else {
      return Collections.emptyList();
    }


  }

  @Override
  public void updateCompany(Company company) {
    companyRepository.save(company);
  }

  @Override
  public Company findOne(Long theId) {
    return companyRepository.findOne(theId);
  }


}
