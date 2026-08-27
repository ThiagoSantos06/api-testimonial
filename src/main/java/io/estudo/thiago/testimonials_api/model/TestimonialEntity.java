package io.estudo.thiago.testimonials_api.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Getter
@Setter
@Table(name = "testimonials")
public class TestimonialEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(name = "name", length = 50, nullable = false)
    private String name;

    @Column(name = "project_name", length = 50, nullable = false)
    private String projectName;

    @Column(name = "position", length = 50)
    private String position;

    @Column(name = "testimonial", columnDefinition = "TEXT", nullable = false)
    private String testimonial;

    @Column(name = "testimonial_date", nullable = false)
    private LocalDateTime testimonialDate;

    @PrePersist
    public void onCreate() {
        testimonialDate = LocalDateTime.now();
    }
}
