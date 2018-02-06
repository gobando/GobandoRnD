package com.intertec.hr.referralProgram.uiproto.repository;

import com.intertec.hr.referralProgram.uiproto.domain.JobPositionVacancy;
import com.intertec.hr.referralProgram.uiproto.domain.JobPositionVacancyPK;
import org.springframework.data.repository.CrudRepository;

/**
 * @author gobando
 */
public interface JobPositionVacancyRepository extends CrudRepository<JobPositionVacancy, JobPositionVacancyPK> {

}