package org.sopt.collaboration.domain.review.entity;

import org.sopt.collaboration.domain.common.BaseEntity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "review")
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
}
