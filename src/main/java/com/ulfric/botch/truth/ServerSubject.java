package com.ulfric.botch.truth;

import org.bukkit.GameMode;
import org.bukkit.Server;

import com.google.common.truth.FailureStrategy;

public final class ServerSubject extends BotchSubject<ServerSubject, Server> implements NamedAssertions<Server> {

	ServerSubject(FailureStrategy failureStrategy, Server actual) {
		super(failureStrategy, actual);
	}

	@Override
	public String getName() {
		return actual().getName();
	}

	public void hasDefaultGameMode() {
		isNotNull();

		if (defaultGameMode() == null) {
			failed("has a default gamemode");
		}
	}

	public void isDefaultGameMode(GameMode expected) {
		isNotNull();

		if (expected != defaultGameMode()) {
			failedWithRawMessage("Not true that %s (%s) has default gamemode %s",
					actualValueAsString(), defaultGameMode(), expected);
		}
	}

	private GameMode defaultGameMode() {
		return actual().getDefaultGameMode();
	}

}
