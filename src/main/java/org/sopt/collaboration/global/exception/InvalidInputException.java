package org.sopt.collaboration.global.exception;

import org.sopt.collaboration.global.api.code.ErrorCode;

public class InvalidInputException extends BaseException{
	public InvalidInputException(ErrorCode errorCode) {
		super(errorCode);
	}
}
