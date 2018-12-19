package com.sda.controller;

import com.sda.service.NewsletterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController("/api")
public class NewsletterController {

    @Autowired
    private NewsletterService newsletterService;

    @GetMapping("/newsletter")
    public String createNewsletter(@RequestParam("email")String email){
        newsletterService.insertNewsLetter(email);
        return email;
    }
}
