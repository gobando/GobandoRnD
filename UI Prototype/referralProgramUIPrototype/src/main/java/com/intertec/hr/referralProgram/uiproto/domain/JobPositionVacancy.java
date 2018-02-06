/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.intertec.hr.referralProgram.uiproto.domain;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType; 
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author gobando
 */
@Entity
@Table(name = "jobpositionvacancy")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "JobPositionVacancy.findAll", query = "SELECT j FROM JobPositionVacancy j")})
public class JobPositionVacancy implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected JobPositionVacancyPK jobPositionVacancyPK;
    @Basic(optional = false)
    @NotNull
    @Column(name = "vacancyState")
    private int vacancyState;
    @Basic(optional = false)
    @NotNull
    @Column(name = "vacancySlots")
    private int vacancySlots;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "jobPositionVacancy", fetch = FetchType.LAZY)
    private List<VacancyReferral> vacancyReferralList;
    @JoinColumn(name = "positionId", referencedColumnName = "positionId", insertable = false, updatable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private JobPosition jobPosition;

    public JobPositionVacancy() {
    }

    public JobPositionVacancy(JobPositionVacancyPK jobPositionVacancyPK) {
        this.jobPositionVacancyPK = jobPositionVacancyPK;
    }

    public JobPositionVacancy(JobPositionVacancyPK jobPositionVacancyPK, int vacancyState, int vacancySlots) {
        this.jobPositionVacancyPK = jobPositionVacancyPK;
        this.vacancyState = vacancyState;
        this.vacancySlots = vacancySlots;
    }

    public JobPositionVacancy(int positionId, Date vacancyDate) {
        this.jobPositionVacancyPK = new JobPositionVacancyPK(positionId, vacancyDate);
    }

    public JobPositionVacancyPK getJobPositionVacancyPK() {
        return jobPositionVacancyPK;
    }

    public void setJobPositionVacancyPK(JobPositionVacancyPK jobPositionVacancyPK) {
        this.jobPositionVacancyPK = jobPositionVacancyPK;
    }

    public int getVacancyState() {
        return vacancyState;
    }

    public void setVacancyState(int vacancyState) {
        this.vacancyState = vacancyState;
    }

    public int getVacancySlots() {
        return vacancySlots;
    }

    public void setVacancySlots(int vacancySlots) {
        this.vacancySlots = vacancySlots;
    }

    @XmlTransient
    public List<VacancyReferral> getVacancyReferralList() {
        return vacancyReferralList;
    }

    public void setVacancyReferralList(List<VacancyReferral> vacancyReferralList) {
        this.vacancyReferralList = vacancyReferralList;
    }

    public JobPosition getJobPosition() {
        return jobPosition;
    }

    public void setJobPosition(JobPosition jobPosition) {
        this.jobPosition = jobPosition;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (jobPositionVacancyPK != null ? jobPositionVacancyPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof JobPositionVacancy)) {
            return false;
        }
        JobPositionVacancy other = (JobPositionVacancy) object;
        if ((this.jobPositionVacancyPK == null && other.jobPositionVacancyPK != null) || (this.jobPositionVacancyPK != null && !this.jobPositionVacancyPK.equals(other.jobPositionVacancyPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.infosys.hr.informee.domain.JobPositionVacancy[ jobPositionVacancyPK=" + jobPositionVacancyPK + " ]";
    }
    
}
