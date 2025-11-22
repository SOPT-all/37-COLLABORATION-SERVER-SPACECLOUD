package org.sopt.collaboration.domain.review.controller;

import org.sopt.collaboration.domain.review.dto.response.SliceResponseDto;
import org.sopt.collaboration.domain.review.service.ReviewService;
import org.sopt.collaboration.global.api.code.SuccessCode;
import org.sopt.collaboration.global.api.response.ApiResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.constraints.Positive;

@RestController
@RequestMapping(path = "/api/v1/reviews")
public class ReviewController {
    private final ReviewService reviewService;

    public ReviewController(ReviewService reviewService) {this.reviewService=reviewService;}

    @GetMapping
    public ResponseEntity<ApiResponse<SliceResponseDto<SliceResponseDto.ReviewResponse>>> getAllReviews(
            @RequestParam(name = "page", defaultValue = "1") @Positive int page) {

        return ResponseEntity.ok(
                ApiResponse.success(
                        SuccessCode.OK,
                        reviewService.getAllReviewsWithPaging(page)
                )
        );
    }
}
