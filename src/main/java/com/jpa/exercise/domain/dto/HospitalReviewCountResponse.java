package com.jpa.exercise.domain.dto;

import com.jpa.exercise.domain.Hospital;
import com.jpa.exercise.domain.Review;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Builder
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class HospitalReviewCountResponse {

    private Integer id;
    private String roadNameAddress;
    private String hospitalName;
    private List<Review> reviews;
    private Long reviewsCount;

    public static HospitalReviewCountResponse of(Hospital hospital, Long reviewsCount) {
        return HospitalReviewCountResponse.builder()
                .id(hospital.getId())
                .roadNameAddress(hospital.getRoadNameAddress())
                .hospitalName(hospital.getHospitalName())
                .reviews(hospital.getReviews())
                .reviewsCount(reviewsCount)
                .build();

    }
}
