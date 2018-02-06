/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.intertec.hr.referralProgram.uiproto.service;

import com.intertec.hr.referralProgram.uiproto.repository.VacancyRepository;
import com.intertec.hr.referralProgram.uiproto.repository.JobPositionRepository;
import com.intertec.hr.referralProgram.uiproto.domain.JobPosition;
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
    private JobPositionRepository jobPositionRepository;
    
    @Autowired
    public VacancyService(VacancyRepository vacancyRepository, JobPositionRepository jobPositionRepository){
        this.vacancyRepository = vacancyRepository;
        this.jobPositionRepository = jobPositionRepository;
    }
    
    public List<JobPosition>getAllJobPositions(){
        return (List<JobPosition>) jobPositionRepository.findAll();
    }
    
}
