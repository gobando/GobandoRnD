/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.intertec.hr.referralProgram.uiproto.repository;

import com.intertec.hr.referralProgram.uiproto.domain.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 *
 * @author gobando
 */
public interface UserRepository extends PagingAndSortingRepository<User, String> {
    
}
