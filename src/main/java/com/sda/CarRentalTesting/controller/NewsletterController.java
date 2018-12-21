package com.sda.CarRentalTesting.controller;

import com.sda.CarRentalTesting.model.NewsletterModel;
import com.sda.CarRentalTesting.service.NewsletterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;



@Controller
public class NewsletterController {

    @Autowired
    private NewsletterService newsletterService;

    @GetMapping("/newsletter")
    public ModelAndView indexPage() {
        return new ModelAndView("index")
                .addObject("newsletter", new NewsletterModel())
                .addObject("user", "Alo");
    }

    @PostMapping ModelAndView insertNewsletter(@ModelAttribute("email") final String email) {
        newsletterService.insertNewsLetter(email);
        return new ModelAndView("result").addObject("email", email);
    }
}