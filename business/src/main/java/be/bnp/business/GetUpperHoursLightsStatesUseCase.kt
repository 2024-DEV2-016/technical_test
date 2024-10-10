package be.bnp.business

class GetUpperHoursLightsStatesUseCase {

	operator fun invoke(hours: Int): List<LightState> {
		val lightOnCount = hours / 5
		return List(4) { index -> if (index < lightOnCount) LightState.RED else LightState.OFF }
	}
}