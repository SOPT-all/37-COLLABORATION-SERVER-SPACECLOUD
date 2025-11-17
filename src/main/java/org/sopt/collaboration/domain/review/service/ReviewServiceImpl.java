package org.sopt.collaboration.domain.review.service;

import org.sopt.collaboration.domain.review.dto.response.ReviewResponseDto;
import org.sopt.collaboration.domain.review.entity.Review;
import org.sopt.collaboration.domain.review.repository.ReviewRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

@Service
public class ReviewServiceImpl implements ReviewService {
    private final ReviewRepository reviewRepository;

    public ReviewServiceImpl(ReviewRepository reviewRepository) {
        this.reviewRepository = reviewRepository;
    }

    @Override
    @Transactional(readOnly = true)
    public Page<ReviewResponseDto> getAllReviewsWithPaging(int page, int size){
        Pageable pageable = PageRequest.of(page, size);
        Page<Review> pages = reviewRepository.findAll(pageable);
        return pages.map(ReviewResponseDto::from);
    }

}
