package be.bnp.berlinclocktest.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.unit.dp
import be.bnp.berlinclocktest.util.Constants.TAG
import be.bnp.berlinclocktest.util.getColorFromLightState
import be.bnp.business.models.LightState

@Composable
fun LightRow(modifier: Modifier, lightStates: List<LightState>) {
	Row(modifier = modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceEvenly) {
		lightStates.forEachIndexed { index, lightState ->

			val isFirst = index == 0
			val isLast = index == lightStates.size - 1
			Box(
				modifier = Modifier
					.weight(1f)
					.fillMaxHeight()
					.heightIn(min = 20.dp, max = 50.dp)
					.padding(4.dp)
					.clip(
						RoundedCornerShape(
							topStart = if (isFirst) 16.dp else 0.dp,
							bottomStart = if (isFirst) 16.dp else 0.dp,
							topEnd = if (isLast) 16.dp else 0.dp,
							bottomEnd = if (isLast) 16.dp else 0.dp
						)
					)
					.testTag("$TAG$lightState")
					.background(getColorFromLightState(lightState))
			)
		}
	}
}