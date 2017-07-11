package com.ulfric.botch.truth;

import org.bukkit.plugin.java.JavaPlugin;

import com.google.common.truth.FailureStrategy;
import com.google.common.truth.Subject;
import com.google.common.truth.SubjectFactory;

public final class JavaPluginSubject extends Subject<JavaPluginSubject, JavaPlugin> {

	JavaPluginSubject(FailureStrategy failureStrategy, JavaPlugin actual) {
		super(failureStrategy, actual);
	}

	public void isNamed(String name) {
		isNotNull();

		if (!actual().getName().equals(name)) {
			failWithRawMessage("Not true that %s (%s) is named %s",
					actualAsString(), actual().getName(), name);
		}
	}

	public void isNotNamed(String name) {
		isNotNull();

		if (actual().getName().equals(name)) {
			fail("is not named", name);
		}
	}

	private static final SubjectFactory<JavaPluginSubject, JavaPlugin> FACTORY =
		new SubjectFactory<JavaPluginSubject, JavaPlugin>() {
			@Override
			public JavaPluginSubject getSubject(FailureStrategy failure, JavaPlugin target) {
				return new JavaPluginSubject(failure, target);
			}
		};

	public static final SubjectFactory<JavaPluginSubject, JavaPlugin> javaPlugins() {
		return FACTORY;
	}

}
