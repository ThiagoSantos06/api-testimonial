package io.estudo.thiago.testimonials_api.model.dto;

import java.time.LocalDateTime;
import java.util.UUID;

public record TestimonialsResponseDTO(

        UUID id,
        String nome,
        String projectName,
        String position,
        String testimonials,
        LocalDateTime testimonialsDate
) {
}
