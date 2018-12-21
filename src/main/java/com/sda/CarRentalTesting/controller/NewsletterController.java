package com.sda.CarRentalTesting.controller;

import com.sda.CarRentalTesting.model.NewsletterModel;
import com.sda.CarRentalTesting.service.NewsletterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
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
    @GetMapping(value ="/newsletter/{id}")
    public NewsletterModel getNewsletterById(@PathVariable("id")final Long id){
        return newsletterService.getNewsletterById(id);
    }
    @GetMapping(value="/newsletters")
    public List<NewsletterModel> getAllNewsletters() {
        List<NewsletterModel> newsletterModels = newsletterService.getAllNewsletters();
        return newsletterModels;

    }
 @PutMapping(value = "/newsletter/{id}")


    public HttpStatus updateNewsletterById(@Valid @RequestBody final NewsletterModel newsletterModel){
        newsletterService.updateNewsletterById(newsletterModel);
        return HttpStatus.OK;
    }
    @DeleteMapping(value = "/newsletter/{id}")
    public HttpStatus deleteNewsletterById(@PathVariable("id") final Long id){
        newsletterService.deleteNewsletterById(id);
        return HttpStatus.OK;
    }

//    public HttpStatus deleteNewsletterById

}
