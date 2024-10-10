package be.bnp.business

import be.bnp.business.LightState.OFF
import be.bnp.business.LightState.RED
import org.junit.Assert.assertEquals
import org.junit.Test

class HoursUnitTest {

	@Test
	fun `Upper hours row lights up the correct number of lights`() {
		val useCase = GetUpperHoursLightsStatesUseCase()
		assertEquals(listOf(RED, RED, OFF, OFF), useCase(12))
	}

	@Test
	fun `Lower hours row lights up the correct number of lights`(){
		val useCase = GetLowerHoursLightsStatesUseCase()
		assertEquals(listOf(RED, RED, OFF, OFF), useCase(12))
	}
}