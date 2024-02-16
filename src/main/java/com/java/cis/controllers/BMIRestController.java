package com.java.cis.controllers;
import java.util.Locale;

import com.java.cis.service.BmiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BMIRestController {
    private BmiService service;

    //web service return the data where as web application(eg:RestController) gives the view(eg: html)

    /*@Autowired //Dependency Injection
        private BmiService service;  //variable level (loosely coupling)*/
    @Autowired //constructor level injection (tightly coupling)
    public BMIRestController(BmiService service){
        this.service= service;
    }

    /**
     * Simply selects the home view to render by returning its name.
     *//*
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String input(Locale locale, Model model) {
        System.out.println("Home Page Requested, locale = " + locale);
        return "bmiInput";
    }*/
    @RequestMapping(value = "/bmirest", method = RequestMethod.POST)
    public String result(@RequestParam("height") double heightInInches,
                         @RequestParam("weight") double weightInPounds,
                         Model model) {
        //BmiService service = new BmiService();
        String formattedBMI = service.calculateBMI(heightInInches,weightInPounds);
        //model.addAttribute("bmi", formattedBMI);
        return formattedBMI;
    }
}