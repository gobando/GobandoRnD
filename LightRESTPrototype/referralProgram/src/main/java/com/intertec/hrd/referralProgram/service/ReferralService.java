/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.intertec.hrd.referralProgram.service;

import com.intertec.hrd.referralProgram.domain.Referral;
import java.util.List;
import com.intertec.hrd.referralProgram.repository.ReferralRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author gobando
 */
@Service
public class ReferralService {
    
    private ReferralRepository referralRepository;
    
    @Autowired
    public ReferralService(ReferralRepository referralRepository){
        this.referralRepository = referralRepository;
    }
    
    public boolean createReferral(Referral referral){
        boolean passedProcessFlow = false;
        if(!referralRepository.exists(referral.getReferralEmail())){
            referralRepository.save(referral);
            passedProcessFlow = true;
        }
        return passedProcessFlow;
    }
    
    
    public List<Referral> getAllReferral(){
        return (List<Referral>) referralRepository.findAll();
    }
    
    public List<Referral> getReferralsByReferree(String emailReferree){
        return referralRepository.findByEmailReferree(emailReferree);
    }
    
}
