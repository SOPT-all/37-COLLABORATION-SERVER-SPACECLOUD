package org.sopt.collaboration.global.api.response;

import org.sopt.collaboration.global.api.code.ErrorCode;
import org.sopt.collaboration.global.api.code.SuccessCode;

public record ApiResponse<T>(
		boolean success,
		String code,
		String message,
		T data
) {
	public static <T> ApiResponse<T> success(SuccessCode successCode) {
		return new ApiResponse<>(true, successCode.name(), successCode.getMessage(), null);
	}

	public static <T> ApiResponse<T> success(SuccessCode successCode, T data) {
		return new ApiResponse<>(true, successCode.name(), successCode.getMessage(), data);
	}

	public static <T> ApiResponse<T> failure(ErrorCode errorCode) {
		return new ApiResponse<>(false, errorCode.name(), errorCode.getMessage(), null);
	}
}
