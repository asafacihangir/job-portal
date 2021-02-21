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
@Table(name = "APPLICANT")
public class Applicant {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(name = "id", nullable = false, updatable = false)
  private Long id;


  @Column(name = "educationStatus", nullable = false)
  private String educationStatus;


  @Column(name = "theLastSchool")
  private String theLastSchool;

  @Column(name = "experince")
  private Long experience = 0L;

  @Column(name = "certificateInfo")
  private String certificateInfo;


  @Column(name = "generalInfo")
  private String generalInfo;

  @Column(name = "tel")
  private String tel;

  @Column(name = "userId")
  private Long userId;

  @ManyToOne
  @NotFound(action = NotFoundAction.IGNORE)
  @JoinColumn(name = "userId", referencedColumnName = "id", insertable = false, updatable = false, foreignKey = @ForeignKey(name = "none", value = ConstraintMode.NO_CONSTRAINT))
  private User user;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getEducationStatus() {
    return educationStatus;
  }

  public void setEducationStatus(String educationStatus) {
    this.educationStatus = educationStatus;
  }

  public String getTheLastSchool() {
    return theLastSchool;
  }

  public void setTheLastSchool(String theLastSchool) {
    this.theLastSchool = theLastSchool;
  }

  public Long getExperience() {
    return experience;
  }

  public void setExperience(Long experience) {
    this.experience = experience;
  }

  public String getCertificateInfo() {
    return certificateInfo;
  }

  public void setCertificateInfo(String certificateInfo) {
    this.certificateInfo = certificateInfo;
  }

  public String getGeneralInfo() {
    return generalInfo;
  }

  public void setGeneralInfo(String generalInfo) {
    this.generalInfo = generalInfo;
  }

  public String getTel() {
    return tel;
  }

  public void setTel(String tel) {
    this.tel = tel;
  }

  public Long getUserId() {
    return userId;
  }

  public void setUserId(Long userId) {
    this.userId = userId;
  }

  public User getUser() {
    return user;
  }

  public void setUser(User user) {
    this.user = user;
  }
}
