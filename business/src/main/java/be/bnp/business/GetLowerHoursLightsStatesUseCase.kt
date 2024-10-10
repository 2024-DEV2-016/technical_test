package be.bnp.business

class GetLowerHoursLightsStatesUseCase {

	operator fun invoke(hours: Int): List<LightState> {
		val lightsOnCount = hours % 5
		return List(4) { index -> if (index < lightsOnCount) LightState.RED else LightState.OFF }
	}
}