package com.sda.service;

import com.sda.entity.NewsletterEntity;
import com.sda.repository.NewsletterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NewsletterService {

    @Autowired
    private NewsletterRepository newsletterRepository;

    public void insertNewsLetter(final String email){

        newsletterRepository.save(NewsletterEntity.builder().email(email).build());

}
}
