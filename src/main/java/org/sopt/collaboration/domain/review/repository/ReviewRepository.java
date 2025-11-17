package org.sopt.collaboration.domain.review.repository;

import org.sopt.collaboration.domain.review.entity.Review;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReviewRepository extends JpaRepository<Review, Integer> {
}
