package com.MVNursery.exception;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class PlanterException extends RuntimeException {

	public PlanterException(String message) {
		super(message);
	}

}
