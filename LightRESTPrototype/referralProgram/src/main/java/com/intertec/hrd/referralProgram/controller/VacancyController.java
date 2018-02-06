/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.intertec.hrd.referralProgram.controller;

import com.intertec.hrd.referralProgram.domain.Vacancy;
import com.intertec.hrd.referralProgram.service.VacancyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;

/**
 *
 * @author gobando
 */
@Controller
public class VacancyController {
    
    private VacancyService vacancyService;
    
    @Autowired
    public void setProductService(VacancyService vacancyService) {
        this.vacancyService = vacancyService;
    }
    
    @RequestMapping(value = "/vacancies", method = RequestMethod.GET)
    public String list(Model model){
        model.addAttribute("vacancies", vacancyService.getAllVacancies());
        model.addAttribute("vacancy", new Vacancy());
        model.addAttribute("vacancyEdit", new Vacancy());
        return "vacancies";
    }
    
    
    @RequestMapping(value="/vacancies", method = RequestMethod.POST)
    public String saveVacancy(Vacancy vacancy){
        vacancyService.createVacancy(vacancy);
        return "redirect:vacancies";
    }


    @RequestMapping(value="/vacancies/edit/vacancyId={id}", method = RequestMethod.PUT)
    public String editVacancy(@PathVariable(value = "id") Integer id, Model model,
                               @ModelAttribute("vacancyEdit") Vacancy vacancy){
        System.out.println("<<<<<<<<<<<<<<<<<<<<<IT PASSED THROUGH HERE>>>>>>>>>>>>>>>>>>>>>>>>>");
        //modelAndView.setViewName("vacancies");
        vacancyService.modifyVacancy(vacancy);
        return "redirect:vacancies";
    }
    
    @RequestMapping(value="/vacancy/delete/id={id}", method=RequestMethod.DELETE)
    public String deleteVacancy(@PathVariable(value="id")Long id){
        System.out.println("<<<<<<<<<<<<<<<<<<<<<IT PASSED THROUGH HERE>>>>>>>>>>>>>>>>>>>>>>>>>");
        vacancyService.deleteVacancy(id);
        return "vacancies";
    }
    
    
}
