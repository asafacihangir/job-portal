package com.cihangir.dao;

import com.cihangir.model.Book;
import com.cihangir.model.Company;
import org.springframework.data.repository.CrudRepository;


public interface CompanyRepository extends CrudRepository<Company, Long> {

}
