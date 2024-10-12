package be.bnp.berlinclocktest

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import be.bnp.business.models.BerlinClock
import be.bnp.business.usecases.GetLowerHoursLightStatesUseCase
import be.bnp.business.usecases.GetLowerMinutesLightStatesUseCase
import be.bnp.business.usecases.GetSecondsLightStateUseCase
import be.bnp.business.usecases.GetUpperHoursLightStatesUseCase
import be.bnp.business.usecases.GetUpperMinutesLightStatesUseCase
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import java.time.LocalTime

class ClockViewModel(private val timeProvider: () -> LocalTime = { LocalTime.now() }) : ViewModel() {

	private val _clockStateFlow = MutableStateFlow<State<BerlinClock>>(State.Loading)
	val clockFlow: StateFlow<State<BerlinClock>> = _clockStateFlow

	init {
		viewModelScope.launch {
			while (true) {
				try {
					_clockStateFlow.value = State.Success(buildBerlinClock(timeProvider.invoke()))
				} catch (e: Exception) {
					_clockStateFlow.value = State.Error(e)
				}
				delay(1000L)
			}
		}
	}

	private fun buildBerlinClock(localTime: LocalTime): BerlinClock {
		return BerlinClock(
			GetSecondsLightStateUseCase().invoke(localTime.second),
			GetUpperHoursLightStatesUseCase().invoke(localTime.hour),
			GetLowerHoursLightStatesUseCase().invoke(localTime.hour),
			GetUpperMinutesLightStatesUseCase().invoke(localTime.minute),
			GetLowerMinutesLightStatesUseCase().invoke(localTime.minute)
		)
	}
}