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
import javax.persistence.Embeddable;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author gobando
 */
@Embeddable
public class VacancyReferralPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "refEmail")
    private String refEmail;
    @Basic(optional = false)
    @NotNull
    @Column(name = "positionId")
    private int positionId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "vacancyDate")
    @Temporal(TemporalType.DATE)
    private Date vacancyDate;

    public VacancyReferralPK() {
    }

    public VacancyReferralPK(String refEmail, int positionId, Date vacancyDate) {
        this.refEmail = refEmail;
        this.positionId = positionId;
        this.vacancyDate = vacancyDate;
    }

    public String getRefEmail() {
        return refEmail;
    }

    public void setRefEmail(String refEmail) {
        this.refEmail = refEmail;
    }

    public int getPositionId() {
        return positionId;
    }

    public void setPositionId(int positionId) {
        this.positionId = positionId;
    }

    public Date getVacancyDate() {
        return vacancyDate;
    }

    public void setVacancyDate(Date vacancyDate) {
        this.vacancyDate = vacancyDate;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (refEmail != null ? refEmail.hashCode() : 0);
        hash += (int) positionId;
        hash += (vacancyDate != null ? vacancyDate.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof VacancyReferralPK)) {
            return false;
        }
        VacancyReferralPK other = (VacancyReferralPK) object;
        if ((this.refEmail == null && other.refEmail != null) || (this.refEmail != null && !this.refEmail.equals(other.refEmail))) {
            return false;
        }
        if (this.positionId != other.positionId) {
            return false;
        }
        if ((this.vacancyDate == null && other.vacancyDate != null) || (this.vacancyDate != null && !this.vacancyDate.equals(other.vacancyDate))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.infosys.hr.informee.domain.VacancyReferralPK[ refEmail=" + refEmail + ", positionId=" + positionId + ", vacancyDate=" + vacancyDate + " ]";
    }
    
}
