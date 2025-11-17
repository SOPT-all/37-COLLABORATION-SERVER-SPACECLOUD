package org.sopt.collaboration.domain.magazine.service;

import org.sopt.collaboration.domain.magazine.dto.response.MagazineResponseDto;
import org.sopt.collaboration.domain.magazine.repository.MagazineRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MagazineServiceImpl implements MagazineService {
    private final MagazineRepository magazineRepository;

    public MagazineServiceImpl(MagazineRepository magazineRepository) {
        this.magazineRepository = magazineRepository;
    }

    @Override
    public List<MagazineResponseDto> getAllMagazines() {
        return magazineRepository.findAll()
                .stream()
                .map(MagazineResponseDto::from)
                .toList();
    }

}
