package be.bnp.berlinclocktest.util

import androidx.compose.ui.graphics.Color
import be.bnp.business.models.LightState

fun getColorFromLightState(lightState: LightState): Color {
	return when (lightState) {
		LightState.YELLOW -> Color.Yellow
		LightState.RED -> Color.Red
		LightState.OFF -> Color.Gray
	}
}