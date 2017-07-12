package com.ulfric.botch.truth;

public interface ValueHolder<T> {

	T actualValue();

	String actualValueAsString();

}