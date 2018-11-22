package com.mo.billsys.exceptions;

import com.mo.billsys.utils.Enums.ErrorCode;


public class BadRequestException extends ApplicationException {
	private static final long	serialVersionUID	= 1L;

	public BadRequestException(ErrorCode code, Object... objects) {
		super(code, objects);
	}

	public BadRequestException(ErrorCode code) {
		super(code, new Object[2]);
	}

}
