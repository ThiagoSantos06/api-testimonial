package io.estudo.thiago.testimonials_api.model.dto;

import java.time.LocalDateTime;
import java.util.UUID;

public record TestimonialsResponseDTO(

        UUID id,
        String name,
        String project_name,
        String position,
        String testimonial,
        LocalDateTime testimonial_Date
) {
}
