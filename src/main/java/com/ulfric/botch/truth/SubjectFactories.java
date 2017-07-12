package com.ulfric.botch.truth;

import com.google.common.truth.FailureStrategy;
import com.google.common.truth.Subject;
import com.google.common.truth.SubjectFactory;

import java.util.function.BiFunction;

public class SubjectFactories {

	public static <T, S extends Subject<S, T>> SubjectFactory<S, T> of(BiFunction<FailureStrategy, T, S> function) {
		return new SubjectFactory<S, T>() {

			@Override
			public S getSubject(FailureStrategy failure, T target) {
				return function.apply(failure, target);
			}

		};
	}

	private SubjectFactories() {
	}

}