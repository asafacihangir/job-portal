package com.cihangir.model;

import com.cihangir.enums.UserType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "User")
public class User {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;


  @Column(name = "firstname", nullable = false)
  private String firstname;

  @Column(name = "lastname", nullable = false)
  private String lastname;

  @Column(name = "username", nullable = false,unique = true)
  private String username;

  @Column(name = "password", nullable = false)
  private String password;

  @Column(name = "mail", nullable = false, unique = true)
  private String mail;

  @Column(name = "activated", nullable = false)
  private Boolean activated = false;

  @Column(name = "user_type", nullable = false)
  @Enumerated(EnumType.STRING)
  private UserType userType;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getFirstname() {
    return firstname;
  }

  public void setFirstname(String firstname) {
    this.firstname = firstname;
  }

  public String getLastname() {
    return lastname;
  }

  public void setLastname(String lastname) {
    this.lastname = lastname;
  }

  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public String getMail() {
    return mail;
  }

  public void setMail(String mail) {
    this.mail = mail;
  }

  public Boolean getActivated() {
    return activated;
  }

  public void setActivated(Boolean activated) {
    this.activated = activated;
  }

  public UserType getUserType() {
    return userType;
  }

  public void setUserType(UserType userType) {
    this.userType = userType;
  }
}
