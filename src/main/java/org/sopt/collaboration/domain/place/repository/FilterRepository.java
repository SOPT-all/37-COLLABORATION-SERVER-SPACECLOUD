package org.sopt.collaboration.domain.place.repository;

import org.sopt.collaboration.domain.place.entity.Filter;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FilterRepository extends JpaRepository<Filter, Long> {
}