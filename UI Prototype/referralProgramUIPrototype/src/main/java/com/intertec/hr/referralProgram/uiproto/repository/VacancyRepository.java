/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.intertec.hr.referralProgram.uiproto.repository;

import com.intertec.hr.referralProgram.uiproto.domain.JobPositionVacancy;
import com.intertec.hr.referralProgram.uiproto.domain.JobPositionVacancyPK;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 *
 * @author gobando
 */
public interface VacancyRepository extends PagingAndSortingRepository<JobPositionVacancy, JobPositionVacancyPK>{
    
}
