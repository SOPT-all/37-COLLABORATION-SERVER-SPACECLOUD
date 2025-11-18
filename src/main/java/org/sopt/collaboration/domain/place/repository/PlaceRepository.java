package org.sopt.collaboration.domain.place.repository;

import org.sopt.collaboration.domain.place.entity.Place;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlaceRepository extends JpaRepository<Place, Long>, PlaceSearchRepository {
}
