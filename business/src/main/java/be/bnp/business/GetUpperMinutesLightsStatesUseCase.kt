package be.bnp.business

import be.bnp.business.LightState.OFF
import be.bnp.business.LightState.RED
import be.bnp.business.LightState.YELLOW

class GetUpperMinutesLightsStatesUseCase {

	operator fun invoke(minutes: Int): List<LightState> {
		val lightsOnCount = minutes / 5
		return List(11) { index ->
			when {
				index < lightsOnCount && (index + 1) % 3 == 0 -> RED
				index < lightsOnCount -> YELLOW
				else -> OFF
			}
		}
	}
}