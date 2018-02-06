/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.intertec.hrd.referralProgram.repository;

import com.intertec.hrd.referralProgram.domain.Referral;
import java.util.List;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 *
 * @author gobando
 */
public interface ReferralRepository extends PagingAndSortingRepository<Referral, String>{

    public List<Referral> findByEmailReferree(String emailReferree);
    
    
    
    
}
