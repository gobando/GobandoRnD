/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.intertec.hrd.referralProgram.service;

import com.intertec.hrd.referralProgram.domain.VacancyReferral;
import com.intertec.hrd.referralProgram.repository.VacancyReferralRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author gobando
 */
@Service
public class VacancyReferralService {
    private VacancyReferralRepository vacancyReferralRepository;
    
    @Autowired
    public VacancyReferralService(VacancyReferralRepository vacancyReferralRepository){
        this.vacancyReferralRepository = vacancyReferralRepository;
    }
    
    public List<VacancyReferral> getAllVacancyReferral(){
        return (List<VacancyReferral>) vacancyReferralRepository.findAll();
    }
    
    public boolean createVacancyReferral(VacancyReferral vacancyReferral){
        boolean passedProcessFlow = false;
        
        if(!vacancyReferralRepository.exists(vacancyReferral.getVacancyReferralPK())){
            vacancyReferralRepository.save(vacancyReferral);
        }
        
        return passedProcessFlow;
    }
    
    
}
