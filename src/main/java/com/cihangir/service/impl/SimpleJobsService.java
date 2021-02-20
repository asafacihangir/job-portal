package com.cihangir.service.impl;

import com.cihangir.dao.JobNoticeRepository;
import com.cihangir.model.Company;
import com.cihangir.model.JobNotice;
import com.cihangir.service.JobNoticeService;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
public class SimpleJobsService implements JobNoticeService {

  private final JobNoticeRepository jobNoticeRepository;

  public SimpleJobsService(JobNoticeRepository jobsRepository) {
    this.jobNoticeRepository = jobsRepository;
  }


  @Transactional
  @Override
  public void saveJobs(JobNotice jobs) {
    jobNoticeRepository.save(jobs);
  }

  @Override
  public Iterable<JobNotice> findAllByUserId(Long userId) {
    return jobNoticeRepository.findAll();
  }

  @Override
  public Iterable<JobNotice> findAllByCompanyIdIn(List<Company> companies) {
    List<Long> companyIds = companies.stream().map(Company::getId).collect(
        Collectors.toList());

    return jobNoticeRepository.findAllByCompanyIdIn(companyIds);
  }

  @Override
  public void updateBook(JobNotice jobs) {
    jobNoticeRepository.save(jobs);
  }


  @Override
  public JobNotice findOne(Long theId) {
    return jobNoticeRepository.findOne(theId);
  }

  @Override
  public void deleteBook(Long theId) {
    jobNoticeRepository.delete(theId);
  }

}
