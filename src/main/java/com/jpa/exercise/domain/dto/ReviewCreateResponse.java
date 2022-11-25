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
public class ReviewCreateResponse {
    private Long id;
    private String title;
    private String content;
    private String userName;
    private String message;

    public static ReviewCreateResponse of(Review review) {
        return ReviewCreateResponse.builder()
                .id(review.getId())
                .title(review.getTitle())
                .content(review.getContent())
                .userName(review.getUserName())
                .build();

    }
}