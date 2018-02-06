/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.intertec.hr.referralProgram.uiproto.domain;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author gobando
 */
@Entity
@Table(name = "jobposition")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "JobPosition.findAll", query = "SELECT j FROM JobPosition j")})
public class JobPosition implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "positionId")
    private Integer positionId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "positionTitle")
    private String positionTitle;
    @Size(max = 300)
    @Column(name = "positionDescription")
    private String positionDescription;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "jobPosition", fetch = FetchType.LAZY)
    private List<JobPositionVacancy> jobPositionVacancyList;

    public JobPosition() {
    }

    public JobPosition(Integer positionId) {
        this.positionId = positionId;
    }

    public JobPosition(Integer positionId, String positionTitle) {
        this.positionId = positionId;
        this.positionTitle = positionTitle;
    }

    public Integer getPositionId() {
        return positionId;
    }

    public void setPositionId(Integer positionId) {
        this.positionId = positionId;
    }

    public String getPositionTitle() {
        return positionTitle;
    }

    public void setPositionTitle(String positionTitle) {
        this.positionTitle = positionTitle;
    }

    public String getPositionDescription() {
        return positionDescription;
    }

    public void setPositionDescription(String positionDescription) {
        this.positionDescription = positionDescription;
    }

    @XmlTransient
    public List<JobPositionVacancy> getJobPositionVacancyList() {
        return jobPositionVacancyList;
    }

    public void setJobPositionVacancyList(List<JobPositionVacancy> jobPositionVacancyList) {
        this.jobPositionVacancyList = jobPositionVacancyList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (positionId != null ? positionId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof JobPosition)) {
            return false;
        }
        JobPosition other = (JobPosition) object;
        if ((this.positionId == null && other.positionId != null) || (this.positionId != null && !this.positionId.equals(other.positionId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.infosys.hr.informee.domain.JobPosition[ positionId=" + positionId + " ]";
    }
    
}
