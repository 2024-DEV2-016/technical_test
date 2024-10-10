package be.bnp.business

import be.bnp.business.LightState.OFF
import be.bnp.business.LightState.RED
import be.bnp.business.LightState.YELLOW
import org.junit.Assert.assertEquals
import org.junit.Test

class MinutesUnitTest {

	@Test
	fun `Upper minutes row lights up the correct number of lights`(){
		val useCase = GetUpperMinutesLightsStatesUseCase()
		assertEquals(listOf(YELLOW, YELLOW, RED,YELLOW, YELLOW, RED, YELLOW, OFF, OFF, OFF, OFF), useCase(35))
	}
}