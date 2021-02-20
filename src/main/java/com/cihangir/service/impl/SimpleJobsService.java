package com.cihangir.service.impl;

import com.cihangir.dao.JobsRepository;
import com.cihangir.model.Book;
import com.cihangir.model.Jobs;
import com.cihangir.service.JobsService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
public class SimpleJobsService implements JobsService {

    private final JobsRepository jobsRepository;

    public SimpleJobsService(JobsRepository jobsRepository) {
        this.jobsRepository = jobsRepository;
    }


    @Transactional
    @Override
    public void saveJobs(Jobs jobs) {
        jobsRepository.save(jobs);
    }

    @Override
    public Iterable<Jobs> findAllByUserId(Long userId) {
        return jobsRepository.findAll();
    }

    @Override
    public void updateBook(Jobs jobs) {
        jobsRepository.save(jobs);
    }


    @Override
    public Jobs findOne(Long theId) {
        return jobsRepository.findOne(theId);
    }

    @Override
    public void deleteBook(Long theId) {
        jobsRepository.delete(theId);
    }

}
