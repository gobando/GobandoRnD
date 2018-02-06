/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.intertec.hrd.referralProgram.controller;

import com.intertec.hrd.referralProgram.service.VacancyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author gobando
 */
@Controller
public class LoginController {
    
    @Autowired
    private VacancyService vacancyService;
    private String sessionEmail="";
    
    @RequestMapping(value = "/login")
    public String renderLoginPage(Model model){
        model.addAttribute("sessionEmail", sessionEmail);
        return "login";
    }
    
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String loginUser(Model model){        
        return "redirect:vacancies";
    }
}
