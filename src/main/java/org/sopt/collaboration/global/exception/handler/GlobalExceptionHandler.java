package org.sopt.collaboration.global.exception.handler;

import org.sopt.collaboration.global.api.code.ErrorCode;
import org.sopt.collaboration.global.api.response.ApiResponse;
import org.sopt.collaboration.global.exception.BaseException;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;
import org.springframework.web.servlet.NoHandlerFoundException;

@RestControllerAdvice
public class GlobalExceptionHandler extends BaseExceptionHandler{
	@ExceptionHandler(BaseException.class)
	protected ResponseEntity<ApiResponse<Void>> handleBaseException(BaseException e) {
		return buildErrorResponse(e.getErrorCode());
	}

	@ExceptionHandler(HttpMessageNotReadableException.class)
	protected ResponseEntity<ApiResponse<Void>> handleHttpMessageNotReadable(HttpMessageNotReadableException e) {
		return buildErrorResponse(ErrorCode.INVALID_REQUEST_VALUE);
	}

	@ExceptionHandler(MethodArgumentTypeMismatchException.class)
	protected ResponseEntity<ApiResponse<Void>> handleMethodArgumentTypeMismatchException(
			MethodArgumentTypeMismatchException e) {
		return buildErrorResponse(ErrorCode.INVALID_REQUEST_VALUE);
	}

	@ExceptionHandler(NoHandlerFoundException.class)
	protected ResponseEntity<ApiResponse<Void>> handleNoHandlerFoundException(NoHandlerFoundException e) {
		return buildErrorResponse(ErrorCode.INVALID_ENDPOINT);
	}

	@ExceptionHandler(Exception.class)
	protected ResponseEntity<ApiResponse<Void>> handleException(Exception e) {
		return buildErrorResponse(ErrorCode.UNDEFINED_ERROR);
	}
}
