package org.sopt.collaboration.domain.place.entity.enums.facility;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum FacilityCategory {
	BASIC("기본"),
	ELECTRONICS_EQUIPMENT("전자기기/장비"),
	FOOD_DRINK_CARRY_IN("음식물/주류 반입"),
	INTERIOR_FACILITIES("내부시설"),
	SERVICES("제공/판매 서비스"),
	USAGE_CONDITIONS("이용조건"),
	OPERATION_METHOD("운영방식");

	private final String description;
}
