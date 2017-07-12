package com.ulfric.botch;

import org.junit.jupiter.api.BeforeEach;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;
import org.mockito.Mockito;

import org.bukkit.Bukkit;
import org.bukkit.Server;
import org.bukkit.plugin.PluginDescriptionFile;
import org.bukkit.plugin.java.JavaPlugin;

import org.apache.commons.lang3.reflect.FieldUtils;

import java.io.Reader;
import java.lang.reflect.Field;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Objects;
import java.util.logging.Logger;

@RunWith(JUnitPlatform.class)
public abstract class Botch<T extends JavaPlugin> {

	private final Class<T> pluginType;
	protected T plugin;
	protected Server server;

	public Botch(Class<T> pluginType) {
		Objects.requireNonNull(pluginType, "pluginType");
		this.pluginType = pluginType;
	}

	@BeforeEach
	final void setupBotch() throws Exception {
		setupServer();
		setupPlugin();
	}

	private void setupServer() throws Exception {
		server = Mockito.mock(Server.class);
		Mockito.when(server.getLogger()).thenReturn(Mockito.mock(Logger.class));
		setServer(Bukkit.class, null);
	}

	private void setupPlugin() throws Exception {
		plugin = Mockito.mock(pluginType);
		setServer(JavaPlugin.class, plugin);
		setupPluginDescription();
	}

	private void setServer(Class<?> location, Object holder) throws Exception {
		Field field = location.getDeclaredField("server");
		field.setAccessible(true);
		field.set(holder, server);
	}

	private void setupPluginDescription() throws Exception {
		Path pluginDescription = findPluginDescription();
		PluginDescriptionFile description;
		if (pluginDescription != null) {
			try (Reader reader = Files.newBufferedReader(pluginDescription)) {
				description = new PluginDescriptionFile(reader);
			}
		} else {
			description = new PluginDescriptionFile(null, null, null);
		}

		Field field = FieldUtils.getField(plugin.getClass(), "description", true);
		field.setAccessible(true);
		field.set(plugin, description);
	}

	private Path findPluginDescription() {
		Path plugin = Paths.get("src/main/resources/plugin.yml");
		if (Files.exists(plugin)) {
			return plugin;
		}

		plugin = Paths.get("src/test/resources/plugin.yml");
		if (Files.exists(plugin)) {
			return plugin;
		}

		return null;
	}

}