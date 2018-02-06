package com.intertec.hr.referralProgram.uiproto.repository;

import com.intertec.hr.referralProgram.uiproto.domain.JobPosition;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * @author gobando
 */
public interface JobPositionRepository extends PagingAndSortingRepository<JobPosition, Integer> {
    
    

}