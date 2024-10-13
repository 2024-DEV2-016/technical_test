package be.bnp.berlinclocktest

import androidx.compose.ui.Modifier
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onAllNodesWithTag
import androidx.compose.ui.test.onNodeWithTag
import be.bnp.berlinclocktest.ui.CircleLightBox
import be.bnp.berlinclocktest.ui.ClockDisplay
import be.bnp.berlinclocktest.ui.LightRow
import be.bnp.berlinclocktest.util.Constants.TAG
import be.bnp.berlinclocktest.ui.theme.BerlinClockTestTheme
import be.bnp.business.models.LightState
import be.bnp.business.usecases.GetLowerHoursLightStatesUseCase
import be.bnp.business.usecases.GetLowerMinutesLightStatesUseCase
import be.bnp.business.usecases.GetSecondsLightStateUseCase
import be.bnp.business.usecases.GetUpperHoursLightStatesUseCase
import be.bnp.business.usecases.GetUpperMinutesLightStatesUseCase
import be.bnp.business.usecases.LightStateUseCase
import org.junit.Assert.assertEquals
import org.junit.Rule
import org.junit.Test

class BerlinClockUiTest {

	@get:Rule
	val composeTestRule = createComposeRule()

	private val secondsLightStateUseCase = GetSecondsLightStateUseCase()
	private val upperHoursLightStatesUseCase = GetUpperHoursLightStatesUseCase()
	private val lowerHoursLightStatesUseCase = GetLowerHoursLightStatesUseCase()
	private val upperMinutesLightStatesUseCase = GetUpperMinutesLightStatesUseCase()
	private val lowerMinutesLightStatesUseCase = GetLowerMinutesLightStatesUseCase()

	@Test
	fun secondsLightBox_isYellow_onEvenSeconds() {
		testCircleLightBox(seconds = 2, expectedState = LightState.YELLOW)
	}

	@Test
	fun secondsLightBox_isOff_onOddSeconds() {
		testCircleLightBox(seconds = 1, expectedState = LightState.OFF)
	}

	@Test
	fun upperHoursLightRow_displaysCorrectNumberOfLitLights() {
		testLightRow(13, upperHoursLightStatesUseCase)
	}

	@Test
	fun lowerHoursLightRow_displaysCorrectNumberOfLitLights() {
		testLightRow(13, lowerHoursLightStatesUseCase)
	}

	@Test
	fun upperMinutesLightRow_displaysCorrectNumberOfLitLights() {
		testLightRow(35, upperMinutesLightStatesUseCase)
	}

	@Test
	fun lowerMinutesLightRow_displaysCorrectNumberOfLitLights() {
		testLightRow(35, lowerMinutesLightStatesUseCase)
	}

	@Test
	fun textView_displaysCurrentTime() {
		composeTestRule.setContent {
			BerlinClockTestTheme {
				ClockDisplay(Modifier)
			}
		}

		composeTestRule.onNodeWithTag("clock").assertExists()
	}

	private fun testCircleLightBox(seconds: Int, expectedState: LightState) {
		val lightState = secondsLightStateUseCase(seconds).first()
		composeTestRule.setContent {
			BerlinClockTestTheme {
				CircleLightBox(Modifier, lightState)
			}
		}

		composeTestRule.onNodeWithTag("$TAG${expectedState}").assertExists()
	}

	private fun testLightRow(time: Int, useCase: LightStateUseCase) {
		val lightStates = useCase(time)
		composeTestRule.setContent {
			BerlinClockTestTheme {
				LightRow(Modifier, lightStates)
			}
		}

		assertLightStates(lightStates)
	}

	private fun assertLightStates(lightStates: List<LightState>) {
		assertLightStateCount(LightState.OFF, lightStates)
		assertLightStateCount(LightState.RED, lightStates)
		assertLightStateCount(LightState.YELLOW, lightStates)
	}

	private fun assertLightStateCount(expectedState: LightState, lightStates: List<LightState>) {
		val expectedCount = lightStates.count { it == expectedState }
		val actualCount = composeTestRule.onAllNodesWithTag("$TAG$expectedState").fetchSemanticsNodes().size

		assertEquals("Incorrect number of $expectedState lights", expectedCount, actualCount)
	}
}