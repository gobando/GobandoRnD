/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.intertec.hr.referralProgram.uiproto.service;

import com.intertec.hr.referralProgram.uiproto.domain.Role;
import com.intertec.hr.referralProgram.uiproto.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author gobando
 */
@Service
public class RoleService {
    private RoleRepository roleRepository;

    @Autowired
    public RoleService(RoleRepository roleRepository) {

        this.roleRepository = roleRepository;
    }

    public Role createRole(Role role) {
        if (!roleRepository.exists(role.getRoleId())) {
            roleRepository.save(role);
        }
        return null;
    }

    public Iterable<Role> lookUp() {
        return roleRepository.findAll();
    }

}