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

/**
 *
 * @author gobando
 */
@Embeddable
public class JobPositionVacancyPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Column(name = "positionId")
    private int positionId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "vacancyDate")
    @Temporal(TemporalType.DATE)
    private Date vacancyDate;

    public JobPositionVacancyPK() {
    }

    public JobPositionVacancyPK(int positionId, Date vacancyDate) {
        this.positionId = positionId;
        this.vacancyDate = vacancyDate;
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
        hash += (int) positionId;
        hash += (vacancyDate != null ? vacancyDate.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof JobPositionVacancyPK)) {
            return false;
        }
        JobPositionVacancyPK other = (JobPositionVacancyPK) object;
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
        return "com.infosys.hr.informee.domain.JobPositionVacancyPK[ positionId=" + positionId + ", vacancyDate=" + vacancyDate + " ]";
    }
    
}
