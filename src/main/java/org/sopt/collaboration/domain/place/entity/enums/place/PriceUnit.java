package org.sopt.collaboration.domain.place.entity.enums.place;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum PriceUnit {
	HOUR("시간"),
	MONTH("월"),
	PACKAGE("패키지");

	private final String description;
}
