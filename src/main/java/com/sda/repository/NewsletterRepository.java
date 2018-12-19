package com.sda.repository;

import com.sda.entity.NewsletterEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NewsletterRepository extends CrudRepository<NewsletterEntity, Long> {

}
