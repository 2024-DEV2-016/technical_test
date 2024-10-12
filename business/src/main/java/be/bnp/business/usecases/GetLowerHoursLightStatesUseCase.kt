package be.bnp.business.usecases

import be.bnp.business.models.LightState

class GetLowerHoursLightStatesUseCase: LightStateUseCase {

	override operator fun invoke(hours: Int): List<LightState> {
		val lightsOnCount = hours % 5
		return List(4) { index -> if (index < lightsOnCount) LightState.RED else LightState.OFF }
	}
}