package be.bnp.business.usecases

import be.bnp.business.models.LightState

class GetLowerMinutesLightStatesUseCase: LightStateUseCase {

	override operator fun invoke(minutes: Int): List<LightState> {
		val lightsOnCount = minutes % 5
		return List(4) { index -> if (index < lightsOnCount) LightState.YELLOW else LightState.OFF }
	}
}