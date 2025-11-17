package org.sopt.collaboration.domain.place.entity;

import org.sopt.collaboration.domain.place.entity.enums.facility.FacilityCategory;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor
@Table(name = "facility",
		uniqueConstraints = {
				@UniqueConstraint(
						name = "uk_facility_name_code",
						columnNames = {"name", "code"}
				)
		}
)
public class Facility {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "name", nullable = false, unique = true)
	private String name;

	@Column(name = "code", nullable = false, unique = true)
	private String code;

	@Column(name = "facility_category", nullable = false)
	@Enumerated(value = EnumType.STRING)
	private FacilityCategory facilityCategory;
}
