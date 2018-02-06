/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.intertec.hrd.referralProgram.service;

import com.intertec.hrd.referralProgram.domain.Vacancy;
import com.intertec.hrd.referralProgram.repository.VacancyRepository;

import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author gobando
 */
@Service
public class VacancyService {
    
    private VacancyRepository vacancyRepository;
    
    @Autowired
    public VacancyService(VacancyRepository vacancyRepository){
        this.vacancyRepository = vacancyRepository;
    }
    
    
    public boolean createVacancy(Vacancy vacancy){
        boolean passedProcessFlow = false;
        vacancy.setVacancyDate(new Date());
        if(vacancy.getIdVacancy() == null){
            vacancy.setIdVacancy(new Long(0));
        }
        if(!vacancyRepository.exists(vacancy.getIdVacancy())){
            vacancyRepository.save(vacancy);
            passedProcessFlow = true;
        }
        return passedProcessFlow;
    }


    public boolean modifyVacancy(Vacancy vacancy){
        boolean passedProcessFlow = false;
        if(vacancyRepository.exists(vacancy.getIdVacancy())){
            vacancyRepository.save(vacancy);
            passedProcessFlow = true;
        }
        return passedProcessFlow;
    }
    
    public void deleteVacancy(Long id){
        vacancyRepository.delete(id);
    }

    public List<Vacancy> getAllVacancies(){
        return (List<Vacancy>) vacancyRepository.findAll();
    }
    
    
    public Vacancy getVacancy(Long vacancyId){
        return vacancyRepository.findOne(vacancyId);
    }
    
}
