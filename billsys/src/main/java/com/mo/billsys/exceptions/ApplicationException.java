package com.mo.billsys.exceptions;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mo.billsys.utils.Enums.ErrorCode;


@SuppressWarnings("serial")
public abstract class ApplicationException extends RuntimeException {
	protected static final Logger	logger	= LoggerFactory
													.getLogger(ApplicationException.class);
	protected ErrorCode				code;
	protected String				message;
	protected Exception				ex;

	public ApplicationException(ErrorCode code, String message) {
		this.code = code;
		this.message = message;
	}

	public ApplicationException(ErrorCode code, String message, Exception ex) {
		this.code = code;
		this.message = message;
		this.ex = ex;
		logger.error(message, ex);
	}

	public ApplicationException(ErrorCode code, Object... objects) {
		this.code = code;
		message = code.getText();
		String paramVal = "";
		if (objects != null && objects.length > 0) {
			for (int cnt = 0; cnt < objects.length; cnt++) {
				Object object = objects[cnt];
				if (object != null && object instanceof Exception) {
					ex = (Exception) object;
				} else if (object == null) {
					paramVal = "null";
					message = message.replace("{" + cnt + "}", paramVal);
				} else {
					paramVal = object.toString();
					message = message.replace("{" + cnt + "}", paramVal);
				}
			}
		}
		if (ex != null) {
			logger.error(message, ex);
		} else {
			logger.error(message);
		}
	}

	public ErrorCode getCode() {
		return code;
	}

	public void setCode(ErrorCode code) {
		this.code = code;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Exception getEx() {
		return ex;
	}

	public void setEx(Exception ex) {
		this.ex = ex;
	}

}
