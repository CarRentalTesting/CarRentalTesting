package com.sda.repository;

import com.sda.entity.NewsletterEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface NewsletterRepository extends JpaRepository<NewsletterEntity, Long> {
    Optional<NewsletterEntity> findByEmail(final String email);

    NewsletterEntity findbyEmail(final String email);

    @Override
    Optional<NewsletterEntity> findById(Long aLong);
}

