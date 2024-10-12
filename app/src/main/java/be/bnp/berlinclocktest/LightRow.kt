package be.bnp.berlinclocktest

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.unit.dp
import be.bnp.berlinclocktest.Constants.TAG
import be.bnp.business.models.LightState

@Composable
fun LightRow(lightStates: List<LightState>) {
	Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceEvenly) {
		lightStates.forEach { lightState ->
			Box(
				modifier = Modifier
					.height(50.dp)
					.weight(1f)
					.padding(4.dp)
					.testTag("$TAG$lightState")
					.background(getColorFromLightState(lightState))
			)
		}
	}
}