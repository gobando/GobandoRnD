/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.intertec.hr.referralProgram.uiproto.controller;

import com.intertec.hr.referralProgram.uiproto.domain.JobPosition;
import com.intertec.hr.referralProgram.uiproto.service.VacancyService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author gobando
 */
@Controller
public class VacancyController {
    
    @Autowired
    private VacancyService vacancyService;
    
    @RequestMapping(value="/vacancy", method = RequestMethod.GET)
    public String render(Model model){
        List<JobPosition> jobPositions = vacancyService.getAllJobPositions();
        model.addAttribute("jobPosition", jobPositions);
                
        return "vacancy";        
    }
    
}
