package org.sopt.collaboration.domain.place.repository;

import java.time.LocalDate;
import java.util.List;

import org.sopt.collaboration.domain.place.entity.Place;
import org.sopt.collaboration.domain.place.entity.enums.place.Location;
import org.sopt.collaboration.domain.place.entity.enums.place.PriceUnit;
import org.sopt.collaboration.domain.place.entity.enums.place.PurchaseType;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;

public interface PlaceSearchRepository {
	Slice<Place> searchPlace(
			Location location,
			Integer priceMin,
			Integer priceMax,
			PriceUnit priceUnit,
			PurchaseType purchaseType,
			Integer capacity,
			LocalDate reservationStartDate,
			LocalDate reservationEndDate,
			List<String> filters,
			List<String> facilities,
			Pageable pageable
	);
}
