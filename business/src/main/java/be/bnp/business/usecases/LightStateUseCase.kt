package be.bnp.business.usecases

import be.bnp.business.models.LightState

interface LightStateUseCase {
	operator fun invoke(value: Int): List<LightState>
}