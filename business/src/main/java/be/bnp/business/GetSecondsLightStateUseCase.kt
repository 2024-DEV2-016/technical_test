package be.bnp.business

class GetSecondsLightStateUseCase {

	operator fun invoke(seconds: Int): LightState = if (seconds % 2 == 0) LightState.YELLOW else LightState.OFF
}