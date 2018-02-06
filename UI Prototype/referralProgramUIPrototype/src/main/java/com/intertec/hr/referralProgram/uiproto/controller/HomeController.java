package com.intertec.hr.referralProgram.uiproto.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by gerardoobando.arce on 2/9/2017.
 */
@Controller
public class HomeController {
    @RequestMapping(value = "/")
    public String index(){
        return "indexOriginal";
    }

}
