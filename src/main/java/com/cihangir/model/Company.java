package com.cihangir.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.NotBlank;

@Entity
@Table(name = "COMPANY")
public class Company {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(name = "id", nullable = false, updatable = false)
  private Long id;

  @NotBlank
  @Column(name = "title", nullable = false)
  private String title;

  @NotBlank
  @Column(name = "tel", nullable = false)
  private String tel;

  @NotBlank
  @Column(name = "email", nullable = false,unique = true)
  private String email;

  @NotBlank
  @Column(name = "address", nullable = false)
  private String address;

  @Column(name = "webSiteUrl", nullable = false)
  private String webSiteUrl;

  @NotNull
  @Column(name = "numOfDesigner", nullable = false)
  private Integer numOfDesigner = 0;

  @NotNull
  @Column(name = "userId", nullable = false)
  private Long userId;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public String getTel() {
    return tel;
  }

  public void setTel(String tel) {
    this.tel = tel;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getAddress() {
    return address;
  }

  public void setAddress(String address) {
    this.address = address;
  }

  public String getWebSiteUrl() {
    return webSiteUrl;
  }

  public void setWebSiteUrl(String webSiteUrl) {
    this.webSiteUrl = webSiteUrl;
  }

  public Integer getNumOfDesigner() {
    return numOfDesigner;
  }

  public void setNumOfDesigner(Integer numOfDesigner) {
    this.numOfDesigner = numOfDesigner;
  }

  public Long getUserId() {
    return userId;
  }

  public void setUserId(Long userId) {
    this.userId = userId;
  }
}
