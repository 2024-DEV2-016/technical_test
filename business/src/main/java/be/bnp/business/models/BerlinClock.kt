package be.bnp.business.models

data class BerlinClock(
	val secondsLightState: LightState,
	val upperHoursLightStates: List<LightState>,
	val lowerHoursLightStates: List<LightState>,
	val upperMinutesLightStates: List<LightState>,
	val lowerMinutesLightStates: List<LightState>
)