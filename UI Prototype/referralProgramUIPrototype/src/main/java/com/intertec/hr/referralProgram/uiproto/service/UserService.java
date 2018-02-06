/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.intertec.hr.referralProgram.uiproto.service;

import com.intertec.hr.referralProgram.uiproto.domain.User;
import com.intertec.hr.referralProgram.uiproto.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author gobando
 */
@Service
public class UserService {
    private UserRepository userRepository;
    
    @Autowired
    public UserService(UserRepository userRepository){
        this.userRepository = userRepository;
    }
    
    public User createUser(String email, String name, String lastName, int employeeNumber, int userState){
        if(!userRepository.exists(email)){
            userRepository.save(new User(email, name, lastName, employeeNumber, userState));
        }
        return null;
    }

    public boolean userExists(User user){
        return userRepository.exists(user.getEmail());
    }
    
    public Iterable<User> lookUp(){
        return userRepository.findAll();
    }

    public User findByUsermail(String usermail) {
        return userRepository.findOne(usermail);
    }
}
