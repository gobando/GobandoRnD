/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.intertec.hrd.referralProgram.domain;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.Lob;
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
@XmlRootElement
@Table(name="informeelightdemo.referral")
@NamedQueries({
    @NamedQuery(name = "Referral.findAll", query = "SELECT r FROM Referral r"),
    @NamedQuery(name = "Referral.findByReferralEmail", query = "SELECT r FROM Referral r WHERE r.referralEmail = :referralEmail"),
    @NamedQuery(name = "Referral.findByFullName", query = "SELECT r FROM Referral r WHERE r.fullName = :fullName"),
    @NamedQuery(name = "Referral.findByReferralState", query = "SELECT r FROM Referral r WHERE r.referralState = :referralState"),
    @NamedQuery(name = "Referral.findByEmailReferree", query = "SELECT r FROM Referral r WHERE r.emailReferree = :emailReferree")})
public class Referral implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    private String referralEmail;
    @Basic(optional = false)
    @NotNull
    @Lob
    private byte[] cvDocument;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    private String fullName;
    @Basic(optional = false)
    @NotNull
    private int referralState;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    private String emailReferree;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "referral", fetch = FetchType.LAZY)
    private List<VacancyReferral> vacancyReferralList;

    public Referral() {
    }

    public Referral(String referralEmail) {
        this.referralEmail = referralEmail;
    }

    public Referral(String referralEmail, byte[] cvDocument, String fullName, int referralState, String emailReferree) {
        this.referralEmail = referralEmail;
        this.cvDocument = cvDocument;
        this.fullName = fullName;
        this.referralState = referralState;
        this.emailReferree = emailReferree;
    }

    public String getReferralEmail() {
        return referralEmail;
    }

    public void setReferralEmail(String referralEmail) {
        this.referralEmail = referralEmail;
    }

    public byte[] getCvDocument() {
        return cvDocument;
    }

    public void setCvDocument(byte[] cvDocument) {
        this.cvDocument = cvDocument;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public int getReferralState() {
        return referralState;
    }

    public void setReferralState(int referralState) {
        this.referralState = referralState;
    }

    public String getEmailReferree() {
        return emailReferree;
    }

    public void setEmailReferree(String emailReferree) {
        this.emailReferree = emailReferree;
    }

    @XmlTransient
    public List<VacancyReferral> getVacancyReferralList() {
        return vacancyReferralList;
    }

    public void setVacancyReferralList(List<VacancyReferral> vacancyReferralList) {
        this.vacancyReferralList = vacancyReferralList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (referralEmail != null ? referralEmail.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Referral)) {
            return false;
        }
        Referral other = (Referral) object;
        if ((this.referralEmail == null && other.referralEmail != null) || (this.referralEmail != null && !this.referralEmail.equals(other.referralEmail))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.infosys.hrd.informeelightdemo.domain.Referral[ referralEmail=" + referralEmail + " ]";
    }
    
}
