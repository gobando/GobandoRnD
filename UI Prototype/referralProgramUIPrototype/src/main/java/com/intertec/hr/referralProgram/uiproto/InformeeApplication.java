package com.intertec.hr.referralProgram.uiproto;

import com.intertec.hr.referralProgram.uiproto.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
public class InformeeApplication implements CommandLineRunner{
    
    @Autowired
    private UserService userService;

	public static void main(String[] args) {
		SpringApplication.run(InformeeApplication.class, args);
	}

    @Override
    public void run(String... strings) throws Exception {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        userService.createUser("gerardoobando.arce@infosys.com", "Gerardo", "Obando", 837, 1);
    }
}
