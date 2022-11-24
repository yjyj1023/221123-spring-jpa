package com.jpa.exercise.domain.dto;

import com.jpa.exercise.domain.Book;
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
public class HospitalResponse {

    private Integer id;
    private String roadNameAddress;
    private String hospitalName;
    private List<Review> reviews;

    public static HospitalResponse of(Hospital hospital) {
        return HospitalResponse.builder()
                .id(hospital.getId())
                .roadNameAddress(hospital.getRoadNameAddress())
                .hospitalName(hospital.getHospitalName())
                .reviews(hospital.getReviews())
                .build();

    }
}
