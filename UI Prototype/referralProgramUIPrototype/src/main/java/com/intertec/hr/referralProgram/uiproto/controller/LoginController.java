package com.intertec.hr.referralProgram.uiproto.controller;

import com.intertec.hr.referralProgram.uiproto.domain.User;
import com.intertec.hr.referralProgram.uiproto.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by gerardoobando.arce on 2/15/2017.
 */
@Controller
public class LoginController {

    @Autowired
    private UserService userService;

    @RequestMapping(value="/login")
    public String login(Model model){
        model.addAttribute("loginUser", new User());
        return "login";
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String loginUser(User loginUser){

        if(!userService.userExists(loginUser)){
            return "login";
        }
        return "adminConsole";
    }


}
