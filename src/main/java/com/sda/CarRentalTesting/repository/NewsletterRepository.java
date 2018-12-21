package com.sda.CarRentalTesting.repository;

import com.sda.CarRentalTesting.entity.NewsletterEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface NewsletterRepository extends JpaRepository<NewsletterEntity, Long> {
    Optional<NewsletterEntity> findByEmail(final String email);

    NewsletterEntity findbyEmail(final String email);

    @Override
    Optional<NewsletterEntity> findById(Long aLong);
}

