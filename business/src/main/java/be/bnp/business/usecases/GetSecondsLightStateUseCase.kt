package be.bnp.business.usecases

import be.bnp.business.models.LightState

class GetSecondsLightStateUseCase {

	operator fun invoke(seconds: Int): LightState = if (seconds % 2 == 0) LightState.YELLOW else LightState.OFF
}