package com.intertec.hr.referralProgram.uiproto.repository;

import com.intertec.hr.referralProgram.uiproto.domain.VacancyReferral;
import com.intertec.hr.referralProgram.uiproto.domain.VacancyReferralPK;
import org.springframework.data.repository.CrudRepository;

/**
 * @author gobando
 */
public interface VacancyReferralRepository extends CrudRepository<VacancyReferral, VacancyReferralPK> {

}