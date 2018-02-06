/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.intertec.hr.referralProgram.uiproto.domain;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author gobando
 */
@Entity
@Table(name = "vacancyreferral")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "VacancyReferral.findAll", query = "SELECT v FROM VacancyReferral v")})
public class VacancyReferral implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected VacancyReferralPK vacancyReferralPK;
    @Basic(optional = false)
    @NotNull
    @Column(name = "referralState")
    private int referralState;
    @JoinColumns({
        @JoinColumn(name = "positionId", referencedColumnName = "positionId", insertable = false, updatable = false),
        @JoinColumn(name = "vacancyDate", referencedColumnName = "vacancyDate", insertable = false, updatable = false)})
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private JobPositionVacancy jobPositionVacancy;
    @JoinColumn(name = "refEmail", referencedColumnName = "refEmail", insertable = false, updatable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Referral referral;

    public VacancyReferral() {
    }

    public VacancyReferral(VacancyReferralPK vacancyReferralPK) {
        this.vacancyReferralPK = vacancyReferralPK;
    }

    public VacancyReferral(VacancyReferralPK vacancyReferralPK, int referralState) {
        this.vacancyReferralPK = vacancyReferralPK;
        this.referralState = referralState;
    }

    public VacancyReferral(String refEmail, int positionId, Date vacancyDate) {
        this.vacancyReferralPK = new VacancyReferralPK(refEmail, positionId, vacancyDate);
    }

    public VacancyReferralPK getVacancyReferralPK() {
        return vacancyReferralPK;
    }

    public void setVacancyReferralPK(VacancyReferralPK vacancyReferralPK) {
        this.vacancyReferralPK = vacancyReferralPK;
    }

    public int getReferralState() {
        return referralState;
    }

    public void setReferralState(int referralState) {
        this.referralState = referralState;
    }

    public JobPositionVacancy getJobPositionVacancy() {
        return jobPositionVacancy;
    }

    public void setJobPositionVacancy(JobPositionVacancy jobPositionVacancy) {
        this.jobPositionVacancy = jobPositionVacancy;
    }

    public Referral getReferral() {
        return referral;
    }

    public void setReferral(Referral referral) {
        this.referral = referral;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (vacancyReferralPK != null ? vacancyReferralPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof VacancyReferral)) {
            return false;
        }
        VacancyReferral other = (VacancyReferral) object;
        if ((this.vacancyReferralPK == null && other.vacancyReferralPK != null) || (this.vacancyReferralPK != null && !this.vacancyReferralPK.equals(other.vacancyReferralPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.infosys.hr.informee.domain.VacancyReferral[ vacancyReferralPK=" + vacancyReferralPK + " ]";
    }
    
}
