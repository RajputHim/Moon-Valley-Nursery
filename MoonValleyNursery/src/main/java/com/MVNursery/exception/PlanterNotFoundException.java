package com.MVNursery.exception;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class PlanterNotFoundException extends RuntimeException {

	public PlanterNotFoundException(String message) {
		super(message);
	}

}
