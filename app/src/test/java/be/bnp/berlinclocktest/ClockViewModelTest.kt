package be.bnp.berlinclocktest

import kotlinx.coroutines.flow.first
import kotlinx.coroutines.test.runTest
import org.junit.Assert.assertEquals
import org.junit.Test

class ClockViewModelTest {

	@Test
	fun `The viewModel must start with a Loading state`() = runTest {
		val clockViewModel = ClockViewModel()
		val firstState = clockViewModel.clockFlow.first()
		assertEquals(State.Loading, firstState)
	}
}