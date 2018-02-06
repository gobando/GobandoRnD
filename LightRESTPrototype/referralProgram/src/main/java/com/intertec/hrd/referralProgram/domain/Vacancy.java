/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.intertec.hrd.referralProgram.domain;

import org.hibernate.annotations.Generated;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;
import org.hibernate.annotations.SQLInsert;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.*;
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
@Table(name="informeelightdemo.vacancy")
@NamedQueries({
    @NamedQuery(name = "Vacancy.findAll", query = "SELECT v FROM Vacancy v"),
    @NamedQuery(name = "Vacancy.findByIdVacancy", query = "SELECT v FROM Vacancy v WHERE v.idVacancy = :idVacancy"),
    @NamedQuery(name = "Vacancy.findByJobPositionTitle", query = "SELECT v FROM Vacancy v WHERE v.jobPositionTitle = :jobPositionTitle"),
    @NamedQuery(name = "Vacancy.findByJobPositionSkillDescription", query = "SELECT v FROM Vacancy v WHERE v.jobPositionSkillDescription = :jobPositionSkillDescription"),
    @NamedQuery(name = "Vacancy.findByVacancySlots", query = "SELECT v FROM Vacancy v WHERE v.vacancySlots = :vacancySlots"),
    @NamedQuery(name = "Vacancy.findByVacancyState", query = "SELECT v FROM Vacancy v WHERE v.vacancyState = :vacancyState"),
    @NamedQuery(name = "Vacancy.findByVacancyDate", query = "SELECT v FROM Vacancy v WHERE v.vacancyDate = :vacancyDate")})
public class Vacancy implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableGenerator(name="seqGen",
            table="sequence",
            pkColumnName="SEQ_NAME", // Specify the name of the column of the primary key
            valueColumnName="SEQ_NUMBER", // Specify the name of the column that stores the last value generated
            pkColumnValue="VACANCY_SEQ", initialValue = 1, allocationSize = 1, schema = "informeelightdemo")
    @Id
    @GeneratedValue(strategy=GenerationType.TABLE, generator="seqGen")
    private Long idVacancy;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    private String jobPositionTitle;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 500)
    private String jobPositionSkillDescription;
    @Basic(optional = false)
    @NotNull
    private short vacancySlots;
    @Basic(optional = false)
    @NotNull
    private int vacancyState;
    @Basic(optional = false)
    @NotNull
    @Temporal(TemporalType.DATE)
    private Date vacancyDate;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "vacancy", fetch = FetchType.LAZY)
    private List<VacancyReferral> vacancyReferralList;

    public Vacancy() {
    }

    public Vacancy(Long idVacancy) {
        this.idVacancy = idVacancy;
    }

    public Vacancy(Long idVacancy, String jobPositionTitle, String jobPositionSkillDescription, short vacancySlots, int vacancyState, Date vacancyDate) {
        this.idVacancy = idVacancy;
        this.jobPositionTitle = jobPositionTitle;
        this.jobPositionSkillDescription = jobPositionSkillDescription;
        this.vacancySlots = vacancySlots;
        this.vacancyState = vacancyState;
        this.vacancyDate = vacancyDate;
    }

    public Long getIdVacancy() {
        return idVacancy;
    }

    public void setIdVacancy(Long idVacancy) {
        this.idVacancy = idVacancy;
    }

    public String getJobPositionTitle() {
        return jobPositionTitle;
    }

    public void setJobPositionTitle(String jobPositionTitle) {
        this.jobPositionTitle = jobPositionTitle;
    }

    public String getJobPositionSkillDescription() {
        return jobPositionSkillDescription;
    }

    public void setJobPositionSkillDescription(String jobPositionSkillDescription) {
        this.jobPositionSkillDescription = jobPositionSkillDescription;
    }

    public short getVacancySlots() {
        return vacancySlots;
    }

    public void setVacancySlots(short vacancySlots) {
        this.vacancySlots = vacancySlots;
    }

    public int getVacancyState() {
        return vacancyState;
    }

    public void setVacancyState(int vacancyState) {
        this.vacancyState = vacancyState;
    }

    public Date getVacancyDate() {
        return vacancyDate;
    }

    public void setVacancyDate(Date vacancyDate) {
        this.vacancyDate = vacancyDate;
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
        hash += (idVacancy != null ? idVacancy.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Vacancy)) {
            return false;
        }
        Vacancy other = (Vacancy) object;
        if ((this.idVacancy == null && other.idVacancy != null) || (this.idVacancy != null && !this.idVacancy.equals(other.idVacancy))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.infosys.hrd.informeelightdemo.domain.Vacancy[ idVacancy=" + idVacancy + " ]";
    }
    
}
