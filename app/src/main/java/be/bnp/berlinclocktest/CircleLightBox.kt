package be.bnp.berlinclocktest

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.unit.dp
import be.bnp.berlinclocktest.Constants.TAG
import be.bnp.business.models.LightState

@Composable
fun CircleLightBox(lightState: LightState) {
	Box(
		modifier = Modifier
			.size(100.dp)
			.clip(CircleShape)
			.background(getColorFromLightState(lightState))
			.testTag("$TAG$lightState")
	)
}