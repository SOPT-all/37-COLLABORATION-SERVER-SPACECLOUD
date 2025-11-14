package org.sopt.collaboration.global.api.code;

import org.springframework.http.HttpStatus;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum ErrorCode implements ResultCode {
	BAD_REQUEST(HttpStatus.BAD_REQUEST, "올바른 요청이 아닙니다."),
	INVALID_REQUEST_VALUE(HttpStatus.BAD_REQUEST, "올바른 요청 데이터가 아닙니다."),
	INVALID_ENDPOINT(HttpStatus.NOT_FOUND, "올바른 요청 경로가 아닙니다."),
	NOT_FOUND(HttpStatus.NOT_FOUND, "해당 리소스를 찾을 수 없습니다."),
	CONFLICT(HttpStatus.CONFLICT, "다른 리소스와 충돌합니다."),
	UNDEFINED_ERROR(HttpStatus.INTERNAL_SERVER_ERROR, "정의되지 않은 오류입니다.");

	private final HttpStatus httpStatus;
	private final String message;
}
