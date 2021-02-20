package com.cihangir.service;

import com.cihangir.model.Book;
import com.cihangir.model.Company;
import com.cihangir.model.Jobs;
import org.springframework.transaction.annotation.Transactional;

public interface JobsService {

    @Transactional
    void saveJobs(Jobs jobs);

    Iterable<Jobs> findAllByUserId(Long userId);

    public void updateBook(Jobs jobs);

    public Jobs findOne(Long theId);

    public void deleteBook(Long theId);
}
