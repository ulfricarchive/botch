package com.ulfric.botch.truth;

import org.bukkit.plugin.Plugin;

import com.google.common.truth.FailureStrategy;

import com.ulfric.veracity.NamedAssertions;
import com.ulfric.veracity.VeracitySubject;

public class PluginSubject<T extends Plugin> extends VeracitySubject<PluginSubject<T>, T> implements NamedAssertions<T> {

	PluginSubject(FailureStrategy failureStrategy, T actual) {
		super(failureStrategy, actual);
	}

	@Override
	public String getName() {
		return actual().getName();
	}

}