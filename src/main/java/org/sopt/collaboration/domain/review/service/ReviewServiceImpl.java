package org.sopt.collaboration.domain.review.service;

import org.sopt.collaboration.domain.review.dto.response.SliceResponseDto;
import org.sopt.collaboration.domain.review.entity.Review;
import org.sopt.collaboration.domain.review.repository.ReviewRepository;
import org.springframework.data.domain.Slice;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
@Service
public class ReviewServiceImpl implements ReviewService {

    private final ReviewRepository reviewRepository;
    private static final int PAGE_SIZE = 4;

    public ReviewServiceImpl(ReviewRepository reviewRepository) {
        this.reviewRepository = reviewRepository;
    }

    @Override
    @Transactional(readOnly = true)
    public SliceResponseDto<SliceResponseDto.ReviewResponse> getAllReviewsWithPaging(int page) {

        Pageable pageable = PageRequest.of(page, PAGE_SIZE);

        Slice<Review> slice = reviewRepository.findByOrderByCreatedAtDesc(pageable);

        Slice<SliceResponseDto.ReviewResponse> mapped =
                slice.map(SliceResponseDto.ReviewResponse::from);

        return SliceResponseDto.fromSlice(mapped);
    }
}
