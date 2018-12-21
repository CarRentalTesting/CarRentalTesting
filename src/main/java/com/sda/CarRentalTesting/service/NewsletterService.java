package com.sda.CarRentalTesting.service;

import com.sda.CarRentalTesting.converter.NewsletterEntityToModelConverter;
import com.sda.CarRentalTesting.entity.NewsletterEntity;
import com.sda.CarRentalTesting.model.NewsletterModel;
import com.sda.CarRentalTesting.repository.NewsletterRepository;
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

    public NewsletterModel getNewsletterById(Long id) {
        Optional<NewsletterEntity> newsletterEntity = newsletterRepository.findById(id);
        if (newsletterEntity.isPresent()) {
            return newsletterEntityToModelConverter.toModel(newsletterEntity.get());
        } else {
            throw new RuntimeException("Newsletter not found");
        }
    }

    public List<NewsletterModel> deleteNewsletterById( Long id) {
        Optional<NewsletterEntity> newsletterEntity = newsletterRepository.findById(id);
        if (newsletterEntity.isPresent()) {
            newsletterRepository.delete(newsletterEntity.get());

        }

        return null;
    }

    public void updateNewsletterById(NewsletterModel newsletterModel) {
        Optional<NewsletterEntity> newsletterEntity = newsletterRepository.findById(newsletterModel.getId());
        if (newsletterEntity.isPresent()) {
            newsletterEntity.get().setEmail(newsletterModel.getEmail());
            newsletterRepository.save(newsletterEntity.get());
        }else {
            throw new RuntimeException("Newsletter not found");
        }


    }

}
