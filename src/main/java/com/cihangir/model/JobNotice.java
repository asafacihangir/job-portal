package com.cihangir.model;


import java.util.ArrayList;
import java.util.List;
import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;
import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "JOB_NOTICE")
public class JobNotice {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false, updatable = false)
    private Long id;

    @NotBlank
    @Column(name = "jobTitle", nullable = false)
    private String jobTitle;

    @NotNull
    @Column(name = "companyId", nullable = false)
    private Long companyId;

    @NotBlank
    @Column(name = "position", nullable = false)
    private String position;

    @NotNull
    @Column(name = "numOfBeTaken", nullable = false)
    private Integer numOfBeTaken = 0;


    @NotBlank
    @Column(name = "workType", nullable = false)
    private String workType ;


    @NotBlank
    @Column(name = "explanation", nullable = false)
    private String explanation ;

    @ManyToOne
    @NotFound(action = NotFoundAction.IGNORE)
    @JoinColumn(name = "companyId", referencedColumnName = "id", insertable = false, updatable = false, foreignKey = @ForeignKey(name = "none", value = ConstraintMode.NO_CONSTRAINT))
    private Company company;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "jobNotice")
    private List<JobApply> jobApplies = new ArrayList<>();


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    public Long getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Long companyId) {
        this.companyId = companyId;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public Integer getNumOfBeTaken() {
        return numOfBeTaken;
    }

    public void setNumOfBeTaken(Integer numOfBeTaken) {
        this.numOfBeTaken = numOfBeTaken;
    }

    public String getWorkType() {
        return workType;
    }

    public void setWorkType(String workType) {
        this.workType = workType;
    }

    public String getExplanation() {
        return explanation;
    }

    public void setExplanation(String explanation) {
        this.explanation = explanation;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public List<JobApply> getJobApplies() {
        return jobApplies;
    }

    public void setJobApplies(List<JobApply> jobApplies) {
        this.jobApplies = jobApplies;
    }
}
