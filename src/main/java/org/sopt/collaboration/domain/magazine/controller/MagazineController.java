package org.sopt.collaboration.domain.magazine.controller;

import org.sopt.collaboration.domain.magazine.dto.response.MagazineResponseDto;
import org.springframework.http.HttpStatus;
import org.sopt.collaboration.domain.magazine.service.MagazineService;
import org.sopt.collaboration.global.api.code.SuccessCode;
import org.sopt.collaboration.global.api.response.ApiResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "/api/v1")
public class MagazineController {
    private final MagazineService magazineService;

    public MagazineController(MagazineService magazineService) {this.magazineService=magazineService;}

    @GetMapping("/magazines")
    public ResponseEntity<ApiResponse<List<MagazineResponseDto>>> getAllMagazines() {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(ApiResponse.success(
                        SuccessCode.OK,
                        magazineService.getAllMagazines()
                ));
    }
}
