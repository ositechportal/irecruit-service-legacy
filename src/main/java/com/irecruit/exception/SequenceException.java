package com.irecruit.exception;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SequenceException extends RuntimeException {
	private static final long serialVersionUID = 1L;
	private String errMsg;

	public SequenceException(String errMsg) {
		this.errMsg = errMsg;
	}

}
