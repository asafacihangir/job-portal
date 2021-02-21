package com.cihangir.service.impl;

import com.cihangir.dao.JobApplyRepository;
import com.cihangir.service.JobApplyService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
public class SimpleJobApplyService implements JobApplyService {

  private final JobApplyRepository jobApplyRepository;


  public SimpleJobApplyService(JobApplyRepository jobApplyRepository) {
    this.jobApplyRepository = jobApplyRepository;
  }
}
