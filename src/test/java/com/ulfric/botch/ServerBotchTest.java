package com.ulfric.botch;

import org.junit.jupiter.api.Test;

import com.google.common.truth.Truth;

class ServerBotchTest extends ServerBotch {

	@Test
	void testServerPluginIsCreated() {
		Truth.assertThat(server).isNotNull();
	}

}