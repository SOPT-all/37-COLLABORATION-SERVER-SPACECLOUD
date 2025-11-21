package org.sopt.collaboration.domain.place.service;

import java.time.LocalDate;
import java.util.List;

import org.sopt.collaboration.domain.place.dto.response.CategoriesResponseDto;
import org.sopt.collaboration.domain.place.dto.response.PlaceInfoListDto;
import org.sopt.collaboration.domain.place.entity.Place;
import org.sopt.collaboration.domain.place.entity.enums.place.Location;
import org.sopt.collaboration.domain.place.entity.enums.place.PriceUnit;
import org.sopt.collaboration.domain.place.entity.enums.place.PurchaseType;
import org.sopt.collaboration.domain.place.repository.FilterRepository;
import org.sopt.collaboration.domain.place.repository.PlaceRepository;
import org.sopt.collaboration.global.api.code.ErrorCode;
import org.sopt.collaboration.global.exception.InvalidInputException;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class PlaceServiceImpl implements PlaceService {
	private static final int PAGE_SIZE = 12;
	private final FilterRepository filterRepository;

	private final PlaceRepository placeRepository;

	public PlaceInfoListDto searchPlaces(
			final int page,
			final Location location,
			final Integer priceMin,
			final Integer priceMax,
			final PriceUnit priceUnit,
			final PurchaseType purchaseType,
			final Integer capacity,
			final LocalDate reservationDate,
			final List<String> filters,
			final List<String> facilities
	) {
		if (reservationDate != null && !reservationDate.isAfter(LocalDate.now())) {
			throw new InvalidInputException(ErrorCode.INVALID_REQUEST_VALUE);
		}

		Pageable pageable = PageRequest.of(page - 1, PAGE_SIZE);

		Slice<Place> result = placeRepository.searchPlace(
				location, priceMin, priceMax, priceUnit, purchaseType, capacity,
				reservationDate, filters, facilities, pageable);

		return PlaceInfoListDto.from(result);
	}

	@Override
	public CategoriesResponseDto getCategories() {
		return CategoriesResponseDto.from(filterRepository.findAll());
	}
}
