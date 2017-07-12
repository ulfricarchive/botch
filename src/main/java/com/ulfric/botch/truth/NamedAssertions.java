package com.ulfric.botch.truth;

import java.util.Objects;

public interface NamedAssertions<T> extends ObjectAssertions<T> {

	default void isNamed(String name) {
		isNotNull();

		if (!Objects.equals(name, getName())) {
			failedWithRawMessage("Not true that %s (%s) is named %s",
					actualValueAsString(), getName(), name);
		}
	}

	default void isNotNamed(String name) {
		isNotNull();

		if (Objects.equals(name, getName())) {
			failed("is not named", name);
		}
	}

	String getName();

}