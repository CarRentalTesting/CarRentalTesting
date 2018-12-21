package com.sda.CarRentalTesting.converter;

import com.sda.CarRentalTesting.entity.NewsletterEntity;
import com.sda.CarRentalTesting.model.NewsletterModel;
import org.springframework.stereotype.Component;

@Component
public class NewsletterEntityToModelConverter {
    public NewsletterModel toModel(final NewsletterEntity newsletterEntity){
        NewsletterModel newsletterModel = new NewsletterModel();
        newsletterModel.setId(newsletterEntity.getId());
        newsletterModel.setCreatedAt(newsletterEntity.getCreatedAt());
        newsletterModel.setEmail(newsletterEntity.getEmail());
        return  newsletterModel;
    }
}
