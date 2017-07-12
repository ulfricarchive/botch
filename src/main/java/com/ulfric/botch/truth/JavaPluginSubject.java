package com.ulfric.botch.truth;

import org.bukkit.plugin.java.JavaPlugin;

import com.google.common.truth.FailureStrategy;

public class JavaPluginSubject extends PluginSubject<JavaPlugin> {

	JavaPluginSubject(FailureStrategy failureStrategy, JavaPlugin actual) {
		super(failureStrategy, actual);
	}

}