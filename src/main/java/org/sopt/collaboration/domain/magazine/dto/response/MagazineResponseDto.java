package org.sopt.collaboration.domain.magazine.dto.response;

import org.sopt.collaboration.domain.magazine.entity.Magazine;

public record MagazineResponseDto(
        Long id,
        String title,
        String magazineImageUrl
) {
    public static MagazineResponseDto from (Magazine magazine) {
        return new MagazineResponseDto(
                magazine.getId(),
                magazine.getTitle(),
                magazine.getMagazineImageUrl()
        );
    }
}