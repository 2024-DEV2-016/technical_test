package be.bnp.berlinclocktest

import androidx.lifecycle.ViewModel
import be.bnp.business.models.BerlinClock
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class ClockViewModel : ViewModel() {

	private val _clockStateFlow: StateFlow<State<BerlinClock>> = MutableStateFlow(State.Loading)
	val clockFlow = _clockStateFlow
}