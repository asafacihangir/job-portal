package com.cihangir.dao;

import com.cihangir.model.JobNotice;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JobNoticeRepository extends JpaRepository<JobNotice, Long> {

  List<JobNotice> findAllByCompanyIdIn(List<Long> companyIds);

}

