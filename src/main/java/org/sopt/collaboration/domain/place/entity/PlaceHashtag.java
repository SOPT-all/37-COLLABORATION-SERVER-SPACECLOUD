package org.sopt.collaboration.domain.place.entity;

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
import jakarta.persistence.UniqueConstraint;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "place_hashtag",
		uniqueConstraints = {
				@UniqueConstraint(
						name = "uk_place_hashtag",
						columnNames = {"place_id", "hashtag_id"}
				)
		},
		indexes = {
				@Index(name = "idx_place_hashtag_place_id", columnList = "place_id"),
				@Index(name = "idx_place_hashtag_hashtag_id", columnList = "hashtag_id")
		})
public class PlaceHashtag {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "place_id", foreignKey = @ForeignKey(ConstraintMode.NO_CONSTRAINT))
	private Place place;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "hashtag_id", foreignKey = @ForeignKey(ConstraintMode.NO_CONSTRAINT))
	private Hashtag hashtag;
}
