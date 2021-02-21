package com.cihangir.service.impl;

import com.cihangir.dao.ApplicantRepository;
import com.cihangir.service.ApplicantService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
public class SimpleApplicantService implements ApplicantService {

  private final ApplicantRepository applicantRepository;

  public SimpleApplicantService(ApplicantRepository applicantRepository) {
    this.applicantRepository = applicantRepository;
  }
}
