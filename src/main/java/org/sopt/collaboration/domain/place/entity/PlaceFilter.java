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
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor
@Table(name = "place_filter",
		uniqueConstraints = {
				@UniqueConstraint(
						name = "uk_place_filter",
						columnNames = {"place_id", "filter_id"}
				)
		},
		indexes = {
				@Index(name = "idx_place_filter_place_id", columnList = "place_id"),
				@Index(name = "idx_place_filter_filter_id", columnList = "filter_id")
		})
public class PlaceFilter {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "place_id", foreignKey = @ForeignKey(ConstraintMode.NO_CONSTRAINT))
	private Place place;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "filter_id", foreignKey = @ForeignKey(ConstraintMode.NO_CONSTRAINT))
	private Filter filter;
}
