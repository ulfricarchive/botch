package com.ulfric.botch;

import org.junit.jupiter.api.Test;

import com.google.common.truth.Truth;

class BotchTest extends Botch<BotchPlugin> {

	public BotchTest() {
		super(BotchPlugin.class);
	}

	@Test
	void testEnsurePluginIsCreated() {
		Truth.assertThat(plugin).isNotNull();
	}

}