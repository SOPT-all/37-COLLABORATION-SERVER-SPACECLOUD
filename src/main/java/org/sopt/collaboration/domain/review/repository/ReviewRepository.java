package org.sopt.collaboration.domain.review.repository;

import org.sopt.collaboration.domain.review.entity.Review;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ReviewRepository extends JpaRepository<Review, Long> {

    @Query("""
                select r
                from Review r
                join fetch r.place p
                left join fetch p.placeFilters pf
                left join fetch pf.filter f
                order by r.createdAt desc
            """)
    Slice<Review> findByOrderByCreatedAtDesc(Pageable pageable);

}
