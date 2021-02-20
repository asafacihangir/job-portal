package com.cihangir.dao;

import com.cihangir.model.Company;
import com.cihangir.model.Jobs;
import org.springframework.data.repository.CrudRepository;

public interface JobsRepository extends CrudRepository<Jobs, Long> {

}

