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
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
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
@Table(name = "referral")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Referral.findAll", query = "SELECT r FROM Referral r")})
public class Referral implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "refEmail")
    private String refEmail;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "refName")
    private String refName;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "refLastName")
    private String refLastName;
    @Basic(optional = false)
    @NotNull
    @Column(name = "refState")
    private int refState;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Column(name = "refCVDoc")
    private byte[] refCVDoc;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "referral", fetch = FetchType.LAZY)
    private List<VacancyReferral> vacancyReferralList;
    @JoinColumn(name = "userEmail", referencedColumnName = "email")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private User userEmail;

    public Referral() {
    }

    public Referral(String refEmail) {
        this.refEmail = refEmail;
    }

    public Referral(String refEmail, String refName, String refLastName, int refState, byte[] refCVDoc) {
        this.refEmail = refEmail;
        this.refName = refName;
        this.refLastName = refLastName;
        this.refState = refState;
        this.refCVDoc = refCVDoc;
    }

    public String getRefEmail() {
        return refEmail;
    }

    public void setRefEmail(String refEmail) {
        this.refEmail = refEmail;
    }

    public String getRefName() {
        return refName;
    }

    public void setRefName(String refName) {
        this.refName = refName;
    }

    public String getRefLastName() {
        return refLastName;
    }

    public void setRefLastName(String refLastName) {
        this.refLastName = refLastName;
    }

    public int getRefState() {
        return refState;
    }

    public void setRefState(int refState) {
        this.refState = refState;
    }

    public byte[] getRefCVDoc() {
        return refCVDoc;
    }

    public void setRefCVDoc(byte[] refCVDoc) {
        this.refCVDoc = refCVDoc;
    }

    @XmlTransient
    public List<VacancyReferral> getVacancyReferralList() {
        return vacancyReferralList;
    }

    public void setVacancyReferralList(List<VacancyReferral> vacancyReferralList) {
        this.vacancyReferralList = vacancyReferralList;
    }

    public User getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(User userEmail) {
        this.userEmail = userEmail;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (refEmail != null ? refEmail.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Referral)) {
            return false;
        }
        Referral other = (Referral) object;
        if ((this.refEmail == null && other.refEmail != null) || (this.refEmail != null && !this.refEmail.equals(other.refEmail))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.infosys.hr.informee.domain.Referral[ refEmail=" + refEmail + " ]";
    }
    
}
