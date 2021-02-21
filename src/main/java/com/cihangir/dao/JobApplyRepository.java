package com.cihangir.dao;

import com.cihangir.model.JobApply;
import org.springframework.data.jpa.repository.JpaRepository;


public interface JobApplyRepository extends JpaRepository<JobApply, Long> {
}
