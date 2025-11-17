package org.sopt.collaboration.domain.review.service;

import org.sopt.collaboration.domain.review.dto.response.ReviewResponseDto;
import org.springframework.data.domain.Page;

public interface ReviewService {
    Page<ReviewResponseDto> getAllReviewsWithPaging(int page, int size);
}
