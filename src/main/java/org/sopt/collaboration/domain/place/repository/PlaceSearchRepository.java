package org.sopt.collaboration.domain.place.repository;

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
			List<String> filters,
			List<String> facilities,
			Pageable pageable
	);
}
