package com.jpa.exercise.controller;

import com.jpa.exercise.domain.dto.*;
import com.jpa.exercise.service.ReviewService;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/")
public class HospitalController {

    private final ReviewService reviewService;

    public HospitalController(ReviewService reviewService) {
        this.reviewService = reviewService;
    }

    @PostMapping("/hospitals/{id}")
    public ResponseEntity<ReviewCreateResponse> get(@PathVariable Integer id, @RequestBody ReviewCreateRequest reviewCreateRequest) {
        return ResponseEntity.ok().body(reviewService.add(reviewCreateRequest));
    }

    @GetMapping("/hospitals/{id}")
    public ResponseEntity<HospitalResponse> oneHospital(@PathVariable Integer id) {
        HospitalResponse hospitalResponse = reviewService.findByHospitals(id);
        return ResponseEntity.ok().body(hospitalResponse);
    }

    @GetMapping("/hospitals/{id}/reviews")
    public ResponseEntity<List<ReviewResponse>> oneHospitalReviews(@PathVariable Integer id) {
        return ResponseEntity.ok().body(reviewService.findAllByHospitalId(id));
    }


    @GetMapping("/hospitals")
    public ResponseEntity<List<HospitalResponse>> hospitalList(Pageable pageable) {
        return ResponseEntity.ok().body(reviewService.findHospitals(pageable));
    }

    @GetMapping("/reviews")
    public ResponseEntity<List<ReviewResponse>> reviewsList(Pageable pageable){
        return ResponseEntity.ok().body(reviewService.findReviews(pageable));
    }

    @GetMapping("/reviews/{id}")
    public ResponseEntity<ReviewResponse> oneReview(@PathVariable Long id){
        ReviewResponse reviewResponse = reviewService.findByReviews(id);
        return ResponseEntity.ok().body(reviewResponse);
    }
}
