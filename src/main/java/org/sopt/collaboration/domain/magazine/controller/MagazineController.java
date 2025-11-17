package org.sopt.collaboration.domain.magazine.controller;

import org.sopt.collaboration.domain.magazine.dto.response.MagazineResponseDto;
import org.sopt.collaboration.domain.magazine.entity.Magazine;
import org.sopt.collaboration.domain.magazine.service.MagazineService;
import org.sopt.collaboration.global.api.code.SuccessCode;
import org.sopt.collaboration.global.api.response.ApiResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping
public class MagazineController {
    private final MagazineService magazineService;

    public MagazineController(MagazineService magazineService) {this.magazineService=magazineService;}

    @GetMapping("/api/v1/magazines")
    public ApiResponse<List<MagazineResponseDto>> getAllMagazines() {
        return ApiResponse.success(
                SuccessCode.OK,
                magazineService.getAllMagazines()
        );
    }
}
