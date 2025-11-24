package org.sopt.collaboration.domain.place.repository;

import java.time.LocalDate;
import java.util.List;

import org.sopt.collaboration.domain.place.entity.Place;
import org.sopt.collaboration.domain.place.entity.QFacility;
import org.sopt.collaboration.domain.place.entity.QFilter;
import org.sopt.collaboration.domain.place.entity.QHashtag;
import org.sopt.collaboration.domain.place.entity.QPlace;
import org.sopt.collaboration.domain.place.entity.QPlaceFacility;
import org.sopt.collaboration.domain.place.entity.QPlaceFilter;
import org.sopt.collaboration.domain.place.entity.QPlaceHashtag;
import org.sopt.collaboration.domain.place.entity.QReservation;
import org.sopt.collaboration.domain.place.entity.enums.place.Location;
import org.sopt.collaboration.domain.place.entity.enums.place.PriceUnit;
import org.sopt.collaboration.domain.place.entity.enums.place.PurchaseType;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.data.domain.SliceImpl;
import org.springframework.stereotype.Repository;

import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.JPAExpressions;
import com.querydsl.jpa.impl.JPAQueryFactory;

import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
public class PlaceSearchRepositoryImpl implements PlaceSearchRepository {
	private final JPAQueryFactory queryFactory;

	public Slice<Place> searchPlace(
			final Location location,
			final Integer priceMin,
			final Integer priceMax,
			final PriceUnit priceUnit,
			final PurchaseType purchaseType,
			final Integer capacity,
			final LocalDate reservationDate,
			final List<String> filters,
			final List<String> facilities,
			final Pageable pageable
	) {
		QPlace qPlace = QPlace.place;
		QPlaceHashtag qPlaceHashtag = QPlaceHashtag.placeHashtag;
		QHashtag qHashtag = QHashtag.hashtag;

		List<Place> places = queryFactory.selectDistinct(qPlace)
				.from(qPlace)
				.leftJoin(qPlaceHashtag).on(qPlaceHashtag.place.id.eq(qPlace.id)).fetchJoin()
				.leftJoin(qHashtag).on(qHashtag.id.eq(qPlaceHashtag.hashtag.id)).fetchJoin()
				.where(
						eqLocation(location),
						eqPriceUnit(priceUnit),
						eqPurchaseType(purchaseType),
						priceBetween(priceMin, priceMax),
						loeCapacity(capacity),
						noReservationOverlap(reservationDate),
						existsFacilityByCodes(facilities),
						existsFilterByCodes(filters)
				)
				.orderBy(qPlace.createdAt.desc())
				.limit(pageable.getPageSize() + 1)
				.fetch();

		boolean hasNext = false;
		if (places.size() > pageable.getPageSize()) {
			hasNext = true;
			places.remove(places.size() - 1);
		}

		return new SliceImpl<Place>(places, pageable, hasNext);
	}

	private BooleanExpression eqLocation(Location location) {
		if (location == null)
			return null;

		return QPlace.place.location.eq(location);
	}

	private BooleanExpression eqPriceUnit(PriceUnit unit) {
		if (unit == null)
			return null;

		return QPlace.place.priceUnit.eq(unit);
	}

	private BooleanExpression eqPurchaseType(PurchaseType type) {
		if (type == null)
			return null;

		return QPlace.place.purchaseType.eq(type);
	}

	private BooleanExpression loeCapacity(Integer capacity) {
		if (capacity == null)
			return null;

		return QPlace.place.capacity.loe(capacity);
	}

	private BooleanExpression noReservationOverlap(LocalDate reservationDate) {
		if (reservationDate == null)
			return null;

		QReservation reservation = QReservation.reservation;

		return JPAExpressions
				.selectOne()
				.from(reservation)
				.where(
						reservation.place.id.eq(QPlace.place.id),
						reservation.startDate.loe(reservationDate),
						reservation.endDate.goe(reservationDate)
				)
				.notExists();
	}

	private BooleanExpression priceBetween(Integer min, Integer max) {
		if (min == null && max == null)
			return null;

		if (min == null)
			return QPlace.place.price.loe(max);

		if (max == null)
			return QPlace.place.price.goe(min);

		return QPlace.place.price.between(min, max);
	}

	private BooleanExpression existsFacilityByCodes(List<String> facilities) {
		if (facilities == null || facilities.isEmpty())
			return null;

		QPlaceFacility qPlaceFacility = QPlaceFacility.placeFacility;
		QFacility qFacility = QFacility.facility;

		return JPAExpressions
				.selectOne()
				.from(qPlaceFacility)
				.join(qPlaceFacility.facility, qFacility)
				.where(
						qPlaceFacility.place.id.eq(QPlace.place.id),
						qFacility.code.in(facilities)
				)
				.exists();
	}

	private BooleanExpression existsFilterByCodes(List<String> filters) {
		if (filters == null || filters.isEmpty())
			return null;

		QPlaceFilter qPlaceFilter = QPlaceFilter.placeFilter;
		QFilter qFilter = QFilter.filter;

		return JPAExpressions
				.selectOne()
				.from(qPlaceFilter)
				.join(qPlaceFilter.filter, qFilter)
				.where(
						qPlaceFilter.place.id.eq(QPlace.place.id),
						qFilter.code.in(filters)
				)
				.exists();
	}
}
