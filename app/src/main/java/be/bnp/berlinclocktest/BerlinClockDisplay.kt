package be.bnp.berlinclocktest

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.material3.Text
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import be.bnp.berlinclocktest.ui.theme.BerlinClockTestTheme

@Composable
fun BerlinClockDisplay(modifier: Modifier, viewModel: ClockViewModel = viewModel()) {

	val clockState by viewModel.clockFlow.collectAsState()

	when (clockState) {
		is State.Loading -> {
			Column(
				modifier = modifier
					.fillMaxSize()
					.padding(16.dp),
				horizontalAlignment = Alignment.CenterHorizontally,
				verticalArrangement = Arrangement.Center
			) {
				Text(text = "Loading")
			}
		}

		is State.Error -> {
			val throwable = (clockState as State.Error).throwable
			Column(
				modifier = modifier
					.fillMaxSize()
					.padding(16.dp),
				horizontalAlignment = Alignment.CenterHorizontally,
				verticalArrangement = Arrangement.Center
			) {
				Text(text = throwable.message ?: "An error occurred")
			}
		}

		else -> {
			val berlinClock = (clockState as State.Success).data
			Column(
				modifier = modifier
					.fillMaxSize()
					.padding(16.dp)
					.navigationBarsPadding()
					.statusBarsPadding()
			) {
				Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Center) {
					CircleLightBox(lightState = berlinClock.secondsLightState.first())
				}

				Spacer(modifier = Modifier.height(16.dp))

				LightRow(lightStates = berlinClock.upperHoursLightStates)

				Spacer(modifier = Modifier.height(16.dp))

				LightRow(lightStates = berlinClock.lowerHoursLightStates)

				Spacer(modifier = Modifier.height(16.dp))

				LightRow(lightStates = berlinClock.upperMinutesLightStates)

				Spacer(modifier = Modifier.height(16.dp))

				LightRow(lightStates = berlinClock.lowerMinutesLightStates)

				Spacer(modifier = Modifier.weight(1f))

				Row(verticalAlignment = Alignment.Bottom) {
					ClockDisplay(modifier = modifier)
				}
			}
		}
	}
}

@Preview(showBackground = true)
@Composable
fun BerlinClockDisplayPreview() {
	BerlinClockTestTheme {
		BerlinClockDisplay(Modifier.padding(16.dp))
	}
}