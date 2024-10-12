package be.bnp.berlinclocktest

import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithTag
import be.bnp.berlinclocktest.ui.theme.BerlinClockTestTheme
import be.bnp.business.models.LightState
import be.bnp.business.usecases.GetSecondsLightStateUseCase
import be.bnp.business.usecases.GetUpperHoursLightStatesUseCase
import org.junit.Rule
import org.junit.Test

class BerlinClockUiTest {

	@get:Rule
	val composeTestRule = createComposeRule()

	@Test
	fun onEvenSecondsLightBoxShouldBeYellow() {
		val secondsLightStateUseCase = GetSecondsLightStateUseCase()
		val lightState = secondsLightStateUseCase.invoke(2)
		composeTestRule.setContent {
			BerlinClockTestTheme {
				CircleLightBox(lightState)
			}
		}
		composeTestRule.onNodeWithTag("LightBox${LightState.YELLOW}").assertExists()
	}

	@Test
	fun onOddSecondsLightBoxShouldBeOff() {
		val secondsLightStateUseCase = GetSecondsLightStateUseCase()
		val lightState = secondsLightStateUseCase(1)
		composeTestRule.setContent {
			BerlinClockTestTheme {
				CircleLightBox(lightState)
			}
		}
		composeTestRule.onNodeWithTag("LightBox${LightState.OFF}").assertExists()
	}

	@Test
	fun lightRowLightsUpTheCorrectNumberOfLightsForUpperHours() {
		val upperHoursLightStatesUseCase = GetUpperHoursLightStatesUseCase()
		val lightStates = upperHoursLightStatesUseCase(13)
		composeTestRule.setContent {
			BerlinClockTestTheme {
				LightRow(lightStates)
			}
		}
	}
}