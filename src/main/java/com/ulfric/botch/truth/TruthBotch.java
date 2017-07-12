package com.ulfric.botch.truth;

import org.bukkit.Server;
import org.bukkit.plugin.java.JavaPlugin;

import com.google.common.truth.Truth;

public class TruthBotch {

	public static JavaPluginSubject assertThat(JavaPlugin plugin) {
		return (JavaPluginSubject) Truth.assertAbout(SubjectFactories.of(JavaPluginSubject::new)).that(plugin);
	}

	public static ServerSubject assertThat(Server server) {
		return Truth.assertAbout(SubjectFactories.of(ServerSubject::new)).that(server);
	}

	private TruthBotch() {
	}

}