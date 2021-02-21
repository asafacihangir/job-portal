package com.cihangir.vm;

import com.cihangir.model.JobNotice;

public class ApplicantJobNoticeReportVM {


  private JobNotice jobNotice;

  private boolean applied = false;

  private String applyDate;

  private String appliedTxt;

  public JobNotice getJobNotice() {
    return jobNotice;
  }

  public void setJobNotice(JobNotice jobNotice) {
    this.jobNotice = jobNotice;
  }

  public boolean isApplied() {
    return applied;
  }

  public void setApplied(boolean applied) {
    this.applied = applied;
  }

  public String getApplyDate() {
    return applyDate;
  }

  public void setApplyDate(String applyDate) {
    this.applyDate = applyDate;
  }

  public String getAppliedTxt() {
    return applied ? "Başvuru Yapıldı" : "Yapılmadı";
  }

  public void setAppliedTxt(String appliedTxt) {
    this.appliedTxt = appliedTxt;
  }
}
