package org.sopt.collaboration.domain.place.service;

import java.time.LocalDate;
import java.util.List;

import org.sopt.collaboration.domain.place.dto.response.CategoriesResponseDto;
import org.sopt.collaboration.domain.place.dto.response.PlaceInfoListDto;
import org.sopt.collaboration.domain.place.entity.enums.place.Location;
import org.sopt.collaboration.domain.place.entity.enums.place.PriceUnit;
import org.sopt.collaboration.domain.place.entity.enums.place.PurchaseType;

public interface PlaceService {
    PlaceInfoListDto searchPlaces(
            int page,
            Location location,
            Integer priceMin,
            Integer priceMax,
            PriceUnit priceUnit,
            PurchaseType purchaseType,
            Integer capacity,
            LocalDate reservationDate,
            List<String> filters,
            List<String> facilities
    );

    CategoriesResponseDto getCategories();
}
