package io.estudo.thiago.testimonials_api.model.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record TestimonialsRequestDTO(

        @NotBlank(message = "O nome é obrigatório")
        @Size(max = 50, message = "O nome deve ter no máximo 50 caracteres.")
        String name,

        @NotBlank(message = "O nome do projeto é obrigatório")
        @Size(max = 50, message = "O projeto deve ter no máximo 50 caracteres.")
        String project_name,

        @Size(max = 50, message = "A posição deve ter no máximo 50 caracteres.")
        String position,

        @NotBlank(message = "O depoimento é obrigatório")
        String testimonial
) {
}
