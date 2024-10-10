package be.bnp.business

import org.junit.Assert.assertEquals
import org.junit.Test

class SecondsUnitTest {

	@Test
	fun `Seconds light is on for even seconds`() {
		val useCase = GetSecondsLightStateUseCase()
		assertEquals(LightState.YELLOW, useCase(2))
	}

	@Test
	fun `Seconds light is off for odd seconds`() {
		val useCase = GetSecondsLightStateUseCase()
		assertEquals(LightState.OFF, useCase(3))
	}
}