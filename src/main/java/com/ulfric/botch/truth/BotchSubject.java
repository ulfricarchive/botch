package com.ulfric.botch.truth;

import com.google.common.truth.FailureStrategy;
import com.google.common.truth.Subject;

public class BotchSubject<S extends Subject<S, T>, T> extends Subject<S, T> implements ObjectAssertions<T> {

	public BotchSubject(FailureStrategy failureStrategy, T actual) {
		super(failureStrategy, actual);
	}

	@Override
	public final T actualValue() {
		return actual();
	}

	@Override
	public final String actualValueAsString() {
		return actualAsString();
	}

	@Override
	public final void failed(String verb, Object other) {
		fail(verb, other);
	}

	@Override
	public final void failedWithRawMessage(String message, Object... parameters) {
		failWithRawMessage(message, parameters);
	}

}