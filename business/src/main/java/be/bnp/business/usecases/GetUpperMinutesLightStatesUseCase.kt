package be.bnp.business.usecases

import be.bnp.business.models.LightState
import be.bnp.business.models.LightState.OFF
import be.bnp.business.models.LightState.RED
import be.bnp.business.models.LightState.YELLOW

class GetUpperMinutesLightStatesUseCase {

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