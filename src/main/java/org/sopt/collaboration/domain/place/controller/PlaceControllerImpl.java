package org.sopt.collaboration.domain.place.controller;

import java.time.LocalDate;
import java.util.List;

import org.sopt.collaboration.domain.place.dto.response.CategoriesResponseDto;
import org.sopt.collaboration.domain.place.dto.response.PlaceInfoListDto;
import org.sopt.collaboration.domain.place.entity.enums.place.Location;
import org.sopt.collaboration.domain.place.entity.enums.place.PriceUnit;
import org.sopt.collaboration.domain.place.entity.enums.place.PurchaseType;
import org.sopt.collaboration.domain.place.service.PlaceService;
import org.sopt.collaboration.global.api.code.SuccessCode;
import org.sopt.collaboration.global.api.response.ApiResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.constraints.Positive;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = "/api/v1/place")
public class PlaceControllerImpl implements PlaceController {
	private final PlaceService placeService;

	@GetMapping(path = "/search/{page}")
	public ResponseEntity<ApiResponse<PlaceInfoListDto>> searchPlaces(
			@PathVariable(name = "page") @Positive final int page,
			@RequestParam(name = "location", required = false) final Location location,
			@RequestParam(name = "priceMin", required = false) final Integer priceMin,
			@RequestParam(name = "priceMax", required = false) final Integer priceMax,
			@RequestParam(name = "priceUnit", required = false) final PriceUnit priceUnit,
			@RequestParam(name = "purchaseType", required = false) final PurchaseType purchaseType,
			@RequestParam(name = "capacity", required = false) final Integer capacity,
			@RequestParam(name = "reservationStartDate", required = false) final LocalDate reservationStartDate,
			@RequestParam(name = "reservationEndDate", required = false) final LocalDate reservationEndDate,
			@RequestParam(name = "filter", required = false) final List<String> filters,
			@RequestParam(name = "facility", required = false) final List<String> facilities
	) {
		return ResponseEntity.status(SuccessCode.OK.getHttpStatus())
				.body(ApiResponse.success(
						SuccessCode.OK,
						placeService.searchPlaces(page, location, priceMin, priceMax, priceUnit, purchaseType,
								capacity, reservationStartDate, reservationEndDate, filters, facilities)));
	}

    @GetMapping("/categories")
    public ResponseEntity<ApiResponse<CategoriesResponseDto>> getCategories() {
        return ResponseEntity.ok(
                ApiResponse.success(
                        SuccessCode.OK,
                        placeService.getCategories()
                )
        );
    }
}
