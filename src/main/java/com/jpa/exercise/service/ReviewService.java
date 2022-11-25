package com.jpa.exercise.service;

import com.jpa.exercise.domain.Book;
import com.jpa.exercise.domain.Hospital;
import com.jpa.exercise.domain.Review;
import com.jpa.exercise.domain.dto.*;
import com.jpa.exercise.repository.HospitalRepository;
import com.jpa.exercise.repository.ReviewRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ReviewService {

    private final ReviewRepository reviewRepository;
    private final HospitalRepository hospitalRepository;

    public ReviewService(ReviewRepository reviewRepository, HospitalRepository hospitalRepository) {
        this.reviewRepository = reviewRepository;
        this.hospitalRepository = hospitalRepository;
    }

    public ReviewCreateResponse add(ReviewCreateRequest reviewCreateRequest) {
        Optional<Hospital> hospital = hospitalRepository.findById(reviewCreateRequest.getHospitalId());
        Review review = Review.builder()
                .title(reviewCreateRequest.getTitle())
                .content(reviewCreateRequest.getContent())
                .userName(reviewCreateRequest.getUserName())
                .hospital(hospital.get())
                .build();
        Review savedReview = reviewRepository.save(review);
        return new ReviewCreateResponse(savedReview.getId(), savedReview.getTitle(), savedReview.getContent(), savedReview.getUserName(),
                "리뷰 등록이 성공 했습니다.");
    }

    public List<ReviewResponse> findReviews(Pageable pageable) {
        Page<Review> reviews = reviewRepository.findAll(pageable);
        List<ReviewResponse> reviewResponses = reviews.stream()
                .map(review -> ReviewResponse.of(review)).collect(Collectors.toList());
        return reviewResponses;
    }

    public ReviewResponse findByReviews(Long id) {
        Optional<Review> optReview = reviewRepository.findById(id);
        Review review = optReview.get();
        return ReviewResponse.of(review);
    }

    public List<HospitalResponse> findHospitals(Pageable pageable) {
        Page<Hospital> hospitals = hospitalRepository.findAll(pageable);
        List<HospitalResponse> hospitalResponses = hospitals.stream()
                .map(hospital -> HospitalResponse.of(hospital)).collect(Collectors.toList());
        return hospitalResponses;
    }

    public HospitalResponse findByHospitals(Integer id) {
        Optional<Hospital> optHospital = hospitalRepository.findById(id);
        Hospital hospital = optHospital.get();
        return HospitalResponse.of(hospital);
    }

    public List<ReviewResponse> findAllByHospitalId(Integer id) {
        Hospital hospital = hospitalRepository.findById(id)
                .orElseThrow(()-> new IllegalArgumentException("해당 id가 없습니다."));
        List<ReviewResponse> reviews = reviewRepository.findByHospital(hospital)
                .stream().map(review -> ReviewResponse.builder()
                        .id(review.getId())
                        .title(review.getTitle())
                        .content(review.getContent())
                        .userName(review.getUserName())
                        .build()
                ).collect(Collectors.toList());
        return reviews;
    }
}