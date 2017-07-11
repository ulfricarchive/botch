package com.ulfric.botch.truth;

import org.bukkit.plugin.java.JavaPlugin;

import com.google.common.truth.Truth;

public class TruthBotch {

	public static JavaPluginSubject assertThat(JavaPlugin plugin) {
		return Truth.assertAbout(JavaPluginSubject.javaPlugins()).that(plugin);
	}

	private TruthBotch() {
	}

}