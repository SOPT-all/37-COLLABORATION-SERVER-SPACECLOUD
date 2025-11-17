package org.sopt.collaboration.domain.magazine.service;

import org.sopt.collaboration.domain.magazine.dto.response.MagazineResponseDto;

import java.util.List;

public interface MagazineService {
    List<MagazineResponseDto> getAllMagazines();
}
