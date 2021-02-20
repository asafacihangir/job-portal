package com.cihangir.dao;

import com.cihangir.model.Company;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;


public interface CompanyRepository extends JpaRepository<Company, Long> {

  List<Company> findAllByUserId(Long userId);

}
