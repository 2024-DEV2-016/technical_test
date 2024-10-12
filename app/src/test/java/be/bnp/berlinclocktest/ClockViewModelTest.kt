package be.bnp.berlinclocktest

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import be.bnp.business.models.LightState
import be.bnp.business.models.LightState.OFF
import be.bnp.business.models.LightState.RED
import be.bnp.business.models.LightState.YELLOW
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.drop
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.test.runTest
import kotlinx.coroutines.test.setMain
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import java.time.LocalTime

class ClockViewModelTest {

	@get:Rule
	val instantTaskExecutorRule = InstantTaskExecutorRule()

	private lateinit var viewModel: ClockViewModel

	@Before
	fun setup() {
		Dispatchers.setMain(Dispatchers.Unconfined)
		viewModel = ClockViewModel()
	}

	@Test
	fun `The viewModel must start with a Loading state`() = runTest {
		val firstState = viewModel.clockFlow.first()
		assertEquals(State.Loading, firstState)
	}

	@Test
	fun `The viewModel should return clocks after the loading`() = runTest {
		val secondState = viewModel.clockFlow.drop(1).first()
		assert(secondState is State.Success)
	}

	@Test
	fun `The BerlinClock returned by the viewModel should reflect the given time`() = runTest {
		val viewModel = ClockViewModel(timeProvider = { LocalTime.of(13, 17, 1)})
		val berlinClock = (viewModel.clockFlow.first { it is State.Success } as State.Success).data

		assertEquals(OFF, berlinClock.secondsLightState)
		assertEquals(listOf(RED, RED, OFF, OFF), berlinClock.upperHoursLightStates)
		assertEquals(listOf(RED, RED, RED, OFF), berlinClock.lowerHoursLightStates)
		assertEquals(listOf(YELLOW, YELLOW, RED, OFF, OFF, OFF, OFF, OFF, OFF, OFF, OFF), berlinClock.upperMinutesLightStates)
		assertEquals(listOf(YELLOW, YELLOW, OFF, OFF), berlinClock.lowerMinutesLightStates)
	}
}