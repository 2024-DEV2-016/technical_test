package be.bnp.business.usecases

import be.bnp.business.models.LightState

class GetSecondsLightStateUseCase: LightStateUseCase {

	override operator fun invoke(seconds: Int) = listOf(if (seconds % 2 == 0) LightState.YELLOW else LightState.OFF)
}