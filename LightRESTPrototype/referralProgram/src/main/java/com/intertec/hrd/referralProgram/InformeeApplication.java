package com.intertec.hrd.referralProgram;

import com.intertec.hrd.referralProgram.domain.Vacancy;
import com.intertec.hrd.referralProgram.service.VacancyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

import java.util.Date;

@SpringBootApplication
public class InformeeApplication implements CommandLineRunner{
    
    @Autowired
    private VacancyService vacancyService;
    //private UserService userService;

	public static void main(String[] args) {
		SpringApplication.run(InformeeApplication.class, args);
	}

    @Override
    public void run(String... strings) throws Exception {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        //userService.createUser("gerardoobando.arce@infosys.com", "Gerardo", "Obando", 837, 1);
        /*Vacancy vacancy = new Vacancy();
        vacancy.setIdVacancy(new Long(1));
        vacancy.setJobPositionTitle("Java Developer");
        vacancy.setJobPositionSkillDescription("Must be a guru");
        vacancy.setVacancyDate(new Date());
        vacancy.setVacancySlots((short) 4);
        vacancy.setVacancyState(1);

        vacancyService.createVacancy(vacancy);*/
    }
}
