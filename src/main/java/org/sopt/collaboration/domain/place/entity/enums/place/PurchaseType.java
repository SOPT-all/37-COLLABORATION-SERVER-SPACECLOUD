package org.sopt.collaboration.domain.place.entity.enums.place;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum PurchaseType {
	DIRECT("바로결제"),
	APPROVE("승인결제");

	private final String description;
}
