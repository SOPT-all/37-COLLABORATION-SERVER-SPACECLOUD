package org.sopt.collaboration.global.exception;

import org.sopt.collaboration.global.api.code.ErrorCode;

import lombok.Getter;

@Getter
public abstract class BaseException extends RuntimeException {
	private final ErrorCode errorCode;

	protected BaseException(ErrorCode errorCode) {
		super(errorCode.getMessage());
		this.errorCode = errorCode;
	}
}
