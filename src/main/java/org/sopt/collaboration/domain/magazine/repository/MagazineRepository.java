package org.sopt.collaboration.domain.magazine.repository;

import org.sopt.collaboration.domain.magazine.entity.Magazine;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MagazineRepository extends JpaRepository<Magazine, Integer> {
}
