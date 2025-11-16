package org.sopt.collaboration.domain.place.entity;

import org.sopt.collaboration.domain.place.entity.enums.filter.FilterCategory;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "filter",
		uniqueConstraints = {
				@UniqueConstraint(
						name = "uk_filter_name_code",
						columnNames = {"name", "code"}
				)
		})
public class Filter {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "name", nullable = false, unique = true)
	private String name;

	@Column(name = "code", nullable = false, unique = true)
	private String code;

	@Column(name = "filter_category", nullable = false)
	@Enumerated(value = EnumType.STRING)
	private FilterCategory filterCategory;
}
