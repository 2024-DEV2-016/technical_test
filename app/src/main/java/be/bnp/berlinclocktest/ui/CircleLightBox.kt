package be.bnp.berlinclocktest.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.platform.testTag
import be.bnp.berlinclocktest.util.Constants.TAG
import be.bnp.berlinclocktest.util.getColorFromLightState
import be.bnp.business.models.LightState

@Composable
fun CircleLightBox(modifier: Modifier, lightState: LightState) {
	Row(modifier = modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Center) {
		Box(
			modifier = modifier
				.aspectRatio(ratio = 1f, matchHeightConstraintsFirst = true)
				.weight(1f)
				.clip(CircleShape)
				.background(getColorFromLightState(lightState))
				.testTag("$TAG$lightState")
		)
	}
}