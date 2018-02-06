/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.intertec.hrd.referralProgram.domain;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Embeddable;
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
    private int idVacancy;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    private String referralEmail;

    public VacancyReferralPK() {
    }

    public VacancyReferralPK(int idVacancy, String referralEmail) {
        this.idVacancy = idVacancy;
        this.referralEmail = referralEmail;
    }

    public int getIdVacancy() {
        return idVacancy;
    }

    public void setIdVacancy(int idVacancy) {
        this.idVacancy = idVacancy;
    }

    public String getReferralEmail() {
        return referralEmail;
    }

    public void setReferralEmail(String referralEmail) {
        this.referralEmail = referralEmail;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) idVacancy;
        hash += (referralEmail != null ? referralEmail.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof VacancyReferralPK)) {
            return false;
        }
        VacancyReferralPK other = (VacancyReferralPK) object;
        if (this.idVacancy != other.idVacancy) {
            return false;
        }
        if ((this.referralEmail == null && other.referralEmail != null) || (this.referralEmail != null && !this.referralEmail.equals(other.referralEmail))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.infosys.hrd.informeelightdemo.domain.VacancyReferralPK[ idVacancy=" + idVacancy + ", referralEmail=" + referralEmail + " ]";
    }
    
}
