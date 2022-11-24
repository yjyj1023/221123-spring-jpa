package com.jpa.exercise.domain.dto;

import com.jpa.exercise.domain.Review;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class ReviewResponse {
    private Long id;
    private String title;
    private String content;
    private String userName;

    public static ReviewResponse of(Review review) {
        return ReviewResponse.builder()
                .id(review.getId())
                .title(review.getTitle())
                .content(review.getContent())
                .userName(review.getUserName())
                .build();

    }
}
