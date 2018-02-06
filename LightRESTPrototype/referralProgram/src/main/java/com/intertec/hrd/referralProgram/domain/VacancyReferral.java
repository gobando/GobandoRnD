/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.intertec.hrd.referralProgram.domain;

import java.io.Serializable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author gobando
 */
@Entity
@XmlRootElement
@Table(name="informeelightdemo.vacancyreferral")
@NamedQueries({
    @NamedQuery(name = "VacancyReferral.findAll", query = "SELECT v FROM VacancyReferral v"),
    @NamedQuery(name = "VacancyReferral.findByIdVacancy", query = "SELECT v FROM VacancyReferral v WHERE v.vacancyReferralPK.idVacancy = :idVacancy"),
    @NamedQuery(name = "VacancyReferral.findByJustAnotherWildCard", query = "SELECT v FROM VacancyReferral v WHERE v.justAnotherWildCard = :justAnotherWildCard"),
    @NamedQuery(name = "VacancyReferral.findByReferralEmail", query = "SELECT v FROM VacancyReferral v WHERE v.vacancyReferralPK.referralEmail = :referralEmail")})
public class VacancyReferral implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected VacancyReferralPK vacancyReferralPK;
    @Size(max = 200)
    private String justAnotherWildCard;
    @JoinColumn(name = "idVacancy", referencedColumnName = "idVacancy", insertable = false, updatable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Vacancy vacancy;
    @JoinColumn(name = "referralEmail", referencedColumnName = "referralEmail", insertable = false, updatable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Referral referral;

    public VacancyReferral() {
    }

    public VacancyReferral(VacancyReferralPK vacancyReferralPK) {
        this.vacancyReferralPK = vacancyReferralPK;
    }

    public VacancyReferral(int idVacancy, String referralEmail) {
        this.vacancyReferralPK = new VacancyReferralPK(idVacancy, referralEmail);
    }

    public VacancyReferralPK getVacancyReferralPK() {
        return vacancyReferralPK;
    }

    public void setVacancyReferralPK(VacancyReferralPK vacancyReferralPK) {
        this.vacancyReferralPK = vacancyReferralPK;
    }

    public String getJustAnotherWildCard() {
        return justAnotherWildCard;
    }

    public void setJustAnotherWildCard(String justAnotherWildCard) {
        this.justAnotherWildCard = justAnotherWildCard;
    }

    public Vacancy getVacancy() {
        return vacancy;
    }

    public void setVacancy(Vacancy vacancy) {
        this.vacancy = vacancy;
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
        return "com.infosys.hrd.informeelightdemo.domain.VacancyReferral[ vacancyReferralPK=" + vacancyReferralPK + " ]";
    }
    
}
