package org.sopt.collaboration.domain.review.controller;

import org.sopt.collaboration.domain.review.dto.response.SliceResponseDto;
import org.sopt.collaboration.domain.review.service.ReviewService;
import org.sopt.collaboration.global.api.code.SuccessCode;
import org.sopt.collaboration.global.api.response.ApiResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/api/v1")
public class ReviewController {
    private final ReviewService reviewService;

    public ReviewController(ReviewService reviewService) {this.reviewService=reviewService;}

    @GetMapping("/reviews")
    public ResponseEntity<ApiResponse<SliceResponseDto<SliceResponseDto.ReviewResponse>>> getAllReviews(
            @RequestParam(defaultValue = "0") int page) {

        return ResponseEntity.ok(
                ApiResponse.success(
                        SuccessCode.OK,
                        reviewService.getAllReviewsWithPaging(page)
                )
        );
    }
}
