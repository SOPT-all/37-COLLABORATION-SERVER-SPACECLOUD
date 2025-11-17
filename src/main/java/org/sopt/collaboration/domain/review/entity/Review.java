package org.sopt.collaboration.domain.review.entity;

import org.sopt.collaboration.domain.common.BaseEntity;
import org.sopt.collaboration.domain.place.entity.Place;

import jakarta.persistence.Column;
import jakarta.persistence.ConstraintMode;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.ForeignKey;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Index;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "review",
indexes = {
		@Index(name = "idx_review-place_id", columnList = "place_id")
})
public class Review extends BaseEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "score", nullable = false)
	private int score;

	@Column(name = "title", nullable = false)
	private String title;

	@Column(name = "detail", nullable = false, columnDefinition = "TEXT")
	private String detail;

	@Column(name = "review_image_url", nullable = false)
	private String reviewImageUrl;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "place_id", foreignKey = @ForeignKey(ConstraintMode.NO_CONSTRAINT))
	private Place place;
}
