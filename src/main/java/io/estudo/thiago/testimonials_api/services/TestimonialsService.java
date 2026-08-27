package io.estudo.thiago.testimonials_api.services;

import io.estudo.thiago.testimonials_api.model.TestimonialEntity;
import io.estudo.thiago.testimonials_api.model.dto.TestimonialsRequestDTO;
import io.estudo.thiago.testimonials_api.model.dto.TestimonialsResponseDTO;
import io.estudo.thiago.testimonials_api.repository.TestimonialsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class TestimonialsService {

    private final TestimonialsRepository testimonialsRepository;

    public List<TestimonialsResponseDTO> findAllTestimonials() {
        return testimonialsRepository.findAll()
                .stream()
                .map(this::toResponse)
                .toList();
    }

    public TestimonialsResponseDTO findTestimonialById(UUID id) {
        TestimonialEntity testimonial =  testimonialsRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Id não encontrado."));

        return toResponse(testimonial);
    }

    public TestimonialsResponseDTO createTestimonials(TestimonialsRequestDTO request) {
        TestimonialEntity testimonial = new TestimonialEntity();
        testimonial.setName(request.name());
        testimonial.setProjectName(request.project_name());
        testimonial.setPosition(request.position());
        testimonial.setTestimonial(request.testimonial());

        testimonial = testimonialsRepository.save(testimonial);
        return toResponse(testimonial);
    }

    public TestimonialsResponseDTO updateTestimonial(UUID id, TestimonialsRequestDTO request) {
        TestimonialEntity testimonial = testimonialsRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Id não encontrado."));
        testimonial.setName(request.name());
        testimonial.setProjectName(request.project_name());
        testimonial.setPosition(request.position());
        testimonial.setTestimonial(request.testimonial());

        testimonial = testimonialsRepository.save(testimonial);
        return toResponse(testimonial);
    }

    public void deleteTestimonial(UUID id) {
        if (!testimonialsRepository.existsById(id)) {
            throw new RuntimeException("Id não encontrado.");
        } else {
            testimonialsRepository.deleteById(id);
        }
    }

    public TestimonialsResponseDTO toResponse(TestimonialEntity testimonial) {
        return new TestimonialsResponseDTO(
            testimonial.getId(),
            testimonial.getName(),
            testimonial.getProjectName(),
            testimonial.getPosition(),
            testimonial.getTestimonial(),
            testimonial.getTestimonialDate()
        );
    }
}
