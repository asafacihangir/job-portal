package com.cihangir.model;

import javax.persistence.Column;
import javax.persistence.ConstraintMode;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

@Entity
@Table
public class JobApply {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(name = "id", nullable = false, updatable = false)
  private Long id;

  @Column(name = "applicantId")
  private Long applicantId;

  @Column(name = "jobNoticeId")
  private Long jobNoticeId;

  @Column(name = "applyDateTime")
  private String applyDateTime;


  @ManyToOne
  @NotFound(action = NotFoundAction.IGNORE)
  @JoinColumn(name = "jobNoticeId", referencedColumnName = "id", insertable = false, updatable = false, foreignKey = @ForeignKey(name = "none", value = ConstraintMode.NO_CONSTRAINT))
  private JobNotice jobNotice;


  @ManyToOne
  @NotFound(action = NotFoundAction.IGNORE)
  @JoinColumn(name = "applicantId", referencedColumnName = "id", insertable = false, updatable = false, foreignKey = @ForeignKey(name = "none", value = ConstraintMode.NO_CONSTRAINT))
  private Applicant applicant;


  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public Long getApplicantId() {
    return applicantId;
  }

  public void setApplicantId(Long applicantId) {
    this.applicantId = applicantId;
  }

  public Long getJobNoticeId() {
    return jobNoticeId;
  }

  public void setJobNoticeId(Long jobNoticeId) {
    this.jobNoticeId = jobNoticeId;
  }

  public String getApplyDateTime() {
    return applyDateTime;
  }

  public void setApplyDateTime(String applyDateTime) {
    this.applyDateTime = applyDateTime;
  }

  public JobNotice getJobNotice() {
    return jobNotice;
  }

  public void setJobNotice(JobNotice jobNotice) {
    this.jobNotice = jobNotice;
  }

  public Applicant getApplicant() {
    return applicant;
  }

  public void setApplicant(Applicant applicant) {
    this.applicant = applicant;
  }
}
