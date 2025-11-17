package org.sopt.collaboration.domain.place.entity.enums.filter;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum FilterCategory {
	WORKSPACE("작업공간"),
	GATHERING("모임공간");

	private final String description;
}
