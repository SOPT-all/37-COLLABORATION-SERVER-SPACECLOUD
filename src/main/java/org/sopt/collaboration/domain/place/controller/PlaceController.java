package org.sopt.collaboration.domain.place.controller;

import java.util.List;

import org.sopt.collaboration.domain.place.dto.response.PlaceInfoListDto;
import org.sopt.collaboration.domain.place.entity.enums.place.Location;
import org.sopt.collaboration.domain.place.entity.enums.place.PriceUnit;
import org.sopt.collaboration.domain.place.entity.enums.place.PurchaseType;
import org.sopt.collaboration.global.api.response.ApiResponse;
import org.springframework.http.ResponseEntity;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = "공간 정보", description = "공간 정보 관련 API")
public interface PlaceController {
	@Operation(summary = "공간 정보 검색", description = "검색 조건을 이용하여 공간 정보를 검색합니다.")
	ResponseEntity<ApiResponse<PlaceInfoListDto>> searchPlaces(
			int page,
			Location location,
			Integer priceMin,
			Integer priceMax,
			PriceUnit priceUnit,
			PurchaseType purchaseType,
			List<String> filters,
			List<String> facilities
	);
}
