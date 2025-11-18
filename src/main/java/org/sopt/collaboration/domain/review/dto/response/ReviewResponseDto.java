package org.sopt.collaboration.domain.review.dto.response;

import jakarta.persistence.*;
import org.sopt.collaboration.domain.review.entity.Review;

public record ReviewResponseDto(
        Long id,
        int score,
        String title,
        String detail,
        String reviewImageUrl,
        Long placeId,
        String category
) {
    public static ReviewResponseDto from (Review review) {
        return new ReviewResponseDto(
                review.getId(),
                review.getScore(),
                review.getTitle(),
                review.getDetail(),
                review.getReviewImageUrl(),
                review.getPlace().getId(),
                review.getPlace().getCategory().getDescription()
        );
    }
}
