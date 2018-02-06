/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.intertec.hrd.referralProgram.repository;

import com.intertec.hrd.referralProgram.domain.VacancyReferral;
import com.intertec.hrd.referralProgram.domain.VacancyReferralPK;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 *
 * @author gobando
 */
public interface VacancyReferralRepository extends PagingAndSortingRepository<VacancyReferral, VacancyReferralPK>{
    
}
