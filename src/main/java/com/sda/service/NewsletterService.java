package com.sda.service;

import com.sda.CarRentalTesting.converter.NewsletterEntityToModelConverter;
import com.sda.entity.NewsletterEntity;
import com.sda.model.NewsletterModel;
import com.sda.repository.NewsletterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class NewsletterService {

    @Autowired
    private NewsletterRepository newsletterRepository;
    @Autowired
    private NewsletterEntityToModelConverter newsletterEntityToModelConverter;

    public void insertNewsLetter(final String email) {
        Optional<NewsletterEntity> newsletterEntity = newsletterRepository.findByEmail(email);
        if (!newsletterEntity.isPresent()) {
            newsletterRepository.save(NewsletterEntity.builder().email(email).build());
        }
    }

    public List<NewsletterModel> getAllNewsletters() {
        List<NewsletterEntity> newsletterEntities = newsletterRepository.findAll();
        List<NewsletterModel> newsletterModels = newsletterEntities.stream().map
                (newsletterEntityToModelConverter::toModel).collect(Collectors.toList());
        return newsletterModels;
    }
}