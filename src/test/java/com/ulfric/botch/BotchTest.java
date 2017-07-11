package com.ulfric.botch;

import org.junit.jupiter.api.Test;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;

import com.google.common.truth.Truth;

@RunWith(JUnitPlatform.class)
class BotchTest extends Botch<BotchPlugin> {

	public BotchTest() {
		super(BotchPlugin.class);
	}

	@Test
	void testEnsurePluginIsCreated() {
		Truth.assertThat(plugin).isNotNull();
		System.out.println(plugin.getName());
	}

}