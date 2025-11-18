package org.sopt.collaboration.domain.review.dto.response;

import org.sopt.collaboration.domain.review.entity.Review;
import org.springframework.data.domain.Slice;

import java.util.List;

public record SliceResponseDto<T>(
        List<T> content,
        boolean hasNext
) {
    public static <T> SliceResponseDto<T> fromSlice(Slice<T> slice) {
        return new SliceResponseDto<>(
                slice.getContent(),
                slice.hasNext()
        );
    }


    public record ReviewResponse(
            Long id,
            int score,
            String title,
            String detail,
            String reviewImageUrl,
            Long placeId,
            List<String> categories
    ) {
        public static ReviewResponse from (Review review) {
            return new ReviewResponse(
                    review.getId(),
                    review.getScore(),
                    review.getTitle(),
                    review.getDetail(),
                    review.getReviewImageUrl(),
                    review.getPlace().getId(),
                    review.getPlace().getPlaceFilters().stream()
                            .map(f -> f.getFilter().getFilterCategory().getDescription())
                            .toList()
            );
        }
    }
}
