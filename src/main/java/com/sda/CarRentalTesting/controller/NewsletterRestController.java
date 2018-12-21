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
public class NewsletterRestController {

    @Autowired
    NewsletterService newsletterService;

    @GetMapping(value = "newsletter/{id}")
    public NewsletterModel getNewsletterById(@PathVariable("id") final long id) {
        return newsletterService.getNewsletterById(id);
    }

    @GetMapping(value = "/newsletters")
    public List<NewsletterModel> getAllNewsletters() {
        List<NewsletterModel> newsletterModels = newsletterService.getAllNewsletters();
        return  newsletterModels;
    }

    @PutMapping(value = "/newsletter")
    public HttpStatus updateNewsletterById(@Valid @RequestBody final NewsletterModel newsletterModel) {
        newsletterService.updateNewsletter(newsletterModel);
        return HttpStatus.OK;
    }

    @DeleteMapping(value = "/newsletter/{id}")
    public HttpStatus deleteNewsletterById(@PathVariable("id") final Long id) {
        newsletterService.deleteNewsletter(id);
        return HttpStatus.OK;
    }
}
