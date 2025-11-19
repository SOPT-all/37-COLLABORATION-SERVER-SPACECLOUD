package org.sopt.collaboration.domain.review.dto.response;

import org.sopt.collaboration.domain.place.entity.PlaceFilter;
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
            int price,
            String priceUnit,
            List<CategoryItem> categories
    ) {

        public static ReviewResponse from(Review review) {

            var place = review.getPlace();

            List<CategoryItem> categoryItems = place
                    .getPlaceFilters().stream()
                    .map(CategoryItem::from)
                    .toList();

            return new ReviewResponse(
                    review.getId(),
                    review.getScore(),
                    review.getTitle(),
                    review.getDetail(),
                    review.getReviewImageUrl(),
                    place.getId(),
                    place.getPrice(),
                    place.getPriceUnit().name(),
                    categoryItems
            );
        }
    }

    public record CategoryItem(String code, String name) {
        public static CategoryItem from(PlaceFilter filter) {
            return new CategoryItem(
                    filter.getFilter().getCode(),
                    filter.getFilter().getName()
            );
        }
    }
}