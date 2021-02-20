package com.cihangir.service;

import com.cihangir.model.Company;
import com.cihangir.model.JobNotice;
import java.util.List;
import org.springframework.transaction.annotation.Transactional;

public interface JobNoticeService {

    @Transactional
    void saveJobs(JobNotice jobs);

    Iterable<JobNotice> findAllByUserId(Long userId);

    Iterable<JobNotice> findAllByCompanyIdIn(List<Company> companies);

    public void updateBook(JobNotice jobs);

    public JobNotice findOne(Long theId);

    public void deleteBook(Long theId);
}
