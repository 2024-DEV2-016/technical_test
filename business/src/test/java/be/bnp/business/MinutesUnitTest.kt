package be.bnp.business

import be.bnp.business.models.LightState.OFF
import be.bnp.business.models.LightState.RED
import be.bnp.business.models.LightState.YELLOW
import be.bnp.business.usecases.GetLowerMinutesLightStatesUseCase
import be.bnp.business.usecases.GetUpperMinutesLightStatesUseCase
import org.junit.Assert.assertEquals
import org.junit.Test

class MinutesUnitTest {

	@Test
	fun `Upper minutes row lights up the correct number of lights`(){
		val useCase = GetUpperMinutesLightStatesUseCase()
		assertEquals(listOf(YELLOW, YELLOW, RED,YELLOW, YELLOW, RED, YELLOW, OFF, OFF, OFF, OFF), useCase(35))
	}

	@Test
	fun `Lower minutes row lights up the correct number of lights`(){
		val useCase = GetLowerMinutesLightStatesUseCase()
		assertEquals(listOf(OFF, OFF, OFF, OFF), useCase(35))
	}
}