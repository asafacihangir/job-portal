package com.cihangir.model;


import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "JOBS")
public class Jobs {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false, updatable = false)
    private Long id;

    @NotBlank
    @Column(name = "job_title", nullable = false)
    private String job_title;

    @NotBlank
    @Column(name = "company_name", nullable = false)
    private String company_name;

    @NotBlank
    @Column(name = "position", nullable = false)
    private String position;

    @NotNull
    @Column(name = "numOfbeTaken", nullable = false)
    private Integer numOfbeTaken = 0;

    @NotNull
    @Column(name = "type", nullable = false)
    private String type ;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getJob_title() {
        return job_title;
    }

    public void setJob_title(String job_title) {
        this.job_title = job_title;
    }

    public String getCompany_name() {
        return company_name;
    }

    public void setCompany_name(String company_name) {
        this.company_name = company_name;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public Integer getNumOfbeTaken() {
        return numOfbeTaken;
    }

    public void setNumOfbeTaken(Integer numOfbeTaken) {
        this.numOfbeTaken = numOfbeTaken;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
