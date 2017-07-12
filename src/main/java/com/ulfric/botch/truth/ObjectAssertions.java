package com.ulfric.botch.truth;

public interface ObjectAssertions<T> extends Fallible, ValueHolder<T> {

	void isNotNull();

}