package com.ulfric.botch.truth;

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

}
