package be.bnp.berlinclocktest

import androidx.compose.ui.graphics.Color
import be.bnp.berlinclocktest.util.getColorFromLightState
import be.bnp.business.models.LightState
import org.junit.Assert.assertEquals
import org.junit.Test

class LightStateConversionTest {

	@Test
	fun `getColorFromState returns the right color for a given state`() {
		val redColor = getColorFromLightState(LightState.RED)
		assertEquals(Color.Red, redColor)
		val yellowColor = getColorFromLightState(LightState.YELLOW)
		assertEquals(Color.Yellow, yellowColor)
		val offColor = getColorFromLightState(LightState.OFF)
		assertEquals(Color.Gray, offColor)
	}
}