package com.ulfric.botch;

import org.junit.jupiter.api.Test;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;

import com.google.common.truth.Truth;

@RunWith(JUnitPlatform.class)
class ServerBotchTest extends ServerBotch {

	@Test
	void testServerPluginIsCreated() {
		Truth.assertThat(server).isNotNull();
	}

}