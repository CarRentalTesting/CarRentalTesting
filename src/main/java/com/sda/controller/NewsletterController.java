package com.sda.controller;

import com.sda.entity.NewsletterEntity;
import com.sda.model.NewsletterModel;
import com.sda.service.NewsletterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import java.util.List;


@RestController
@RequestMapping (value ="/api")
public class NewsletterController {

    @Autowired
    private NewsletterService newsletterService;

    @GetMapping("/newsletter")
    public HttpStatus createNewsletter(@RequestParam("email") final String email, HttpStatus ok){
        newsletterService.insertNewsLetter(email);
        return ok;
    }
    @PostMapping(value = "/newsletter")
    public HttpStatus addNewsletter(@RequestParam("email")final String email){
        newsletterService.insertNewsLetter(email);
        return HttpStatus.OK;
    }
    @GetMapping(value="/newsletters")
    public List<NewsletterModel> getAllNewsletters() {
        List<NewsletterModel> newsletterModels = newsletterService.getAllNewsletters();
        return newsletterModels;

    }
//    @PutMapping(value = "/newsletter/{id}")
//    public HttpStatus deleteNewsletterById(@Valid @RequestBody final NewsletterModel newsletterModel){
//        newsletterService.updateNewsletter(newsletterModel);
//        return HttpStatus.OK;
//    }
//    @DeleteMapping(value = "/newsletter/{id}")
//    public HttpStatus deleteNewsletterById

}
