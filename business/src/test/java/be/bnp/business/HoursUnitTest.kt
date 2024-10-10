package be.bnp.business

import be.bnp.business.models.LightState.OFF
import be.bnp.business.models.LightState.RED
import be.bnp.business.usecases.GetLowerHoursLightStatesUseCase
import be.bnp.business.usecases.GetUpperHoursLightStatesUseCase
import org.junit.Assert.assertEquals
import org.junit.Test

class HoursUnitTest {

	@Test
	fun `Upper hours row lights up the correct number of lights`() {
		val useCase = GetUpperHoursLightStatesUseCase()
		assertEquals(listOf(RED, RED, OFF, OFF), useCase(12))
	}

	@Test
	fun `Lower hours row lights up the correct number of lights`(){
		val useCase = GetLowerHoursLightStatesUseCase()
		assertEquals(listOf(RED, RED, OFF, OFF), useCase(12))
	}
}