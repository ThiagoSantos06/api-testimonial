package io.estudo.thiago.testimonials_api.controller;

import io.estudo.thiago.testimonials_api.model.dto.TestimonialsRequestDTO;
import io.estudo.thiago.testimonials_api.model.dto.TestimonialsResponseDTO;
import io.estudo.thiago.testimonials_api.services.TestimonialsService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/testimonials")
@RequiredArgsConstructor
public class TestimonialsController {
    private final TestimonialsService testimonialsService;

    @GetMapping
    public List<TestimonialsResponseDTO> getTestimonials() {
        return testimonialsService.findAllTestimonials();
    }

    @GetMapping("/{id}")
    public TestimonialsResponseDTO getTestimonialById(@PathVariable UUID id) {
        return testimonialsService.findTestimonialById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public TestimonialsResponseDTO createTestimonial(@Valid @RequestBody TestimonialsRequestDTO request) {
        return testimonialsService.createTestimonials(request);
    }

    @PutMapping("/{id}")
    public TestimonialsResponseDTO updateTestimonial(@Valid @PathVariable UUID id, @RequestBody TestimonialsRequestDTO request) {
        return testimonialsService.updateTestimonial(id, request);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void DeleteTestimonial(@PathVariable UUID id) {
        testimonialsService.deleteTestimonial(id);
    }
}
