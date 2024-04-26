package com.example.gticslab420212607.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class EmpleadoController {



    @GetMapping(value ={"","/"})
    public String home(){

        return "home";
    }

}
