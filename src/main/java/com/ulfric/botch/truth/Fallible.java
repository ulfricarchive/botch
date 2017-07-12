package com.ulfric.botch.truth;

public interface Fallible {

	void failed(String verb);

	void failed(String verb, Object other);

	void failedWithRawMessage(String message, Object... parameters);

}