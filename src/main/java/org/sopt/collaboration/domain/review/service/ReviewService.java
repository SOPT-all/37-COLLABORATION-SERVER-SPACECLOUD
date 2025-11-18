package org.sopt.collaboration.domain.review.service;

import org.sopt.collaboration.domain.review.dto.response.ReviewResponseDto;

import org.sopt.collaboration.domain.review.dto.response.SliceResponseDto;
public interface ReviewService {
    SliceResponseDto<ReviewResponseDto> getAllReviewsWithPaging(int page);
}
