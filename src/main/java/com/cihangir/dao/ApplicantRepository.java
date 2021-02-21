package com.cihangir.dao;

import com.cihangir.model.Applicant;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ApplicantRepository extends JpaRepository<Applicant, Long> {

  Optional<Applicant> findByUserId(Long userId);

}
