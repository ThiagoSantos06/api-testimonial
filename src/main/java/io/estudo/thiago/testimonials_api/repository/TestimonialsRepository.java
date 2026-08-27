package io.estudo.thiago.testimonials_api.repository;

import io.estudo.thiago.testimonials_api.model.TestimonialEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface TestimonialsRepository extends JpaRepository<TestimonialEntity, UUID> {
}
