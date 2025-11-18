package org.sopt.collaboration.domain.review.repository;

import org.sopt.collaboration.domain.review.entity.Review;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReviewRepository extends JpaRepository<Review, Long> {

    @EntityGraph(attributePaths = {"place"})
    Slice<Review> findByOrderByCreatedAtDesc(Pageable pageable);

}
