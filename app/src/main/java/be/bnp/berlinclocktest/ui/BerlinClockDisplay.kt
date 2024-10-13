package be.bnp.berlinclocktest.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
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
import be.bnp.berlinclocktest.ClockViewModel
import be.bnp.berlinclocktest.State
import be.bnp.berlinclocktest.ui.theme.BerlinClockTestTheme

@Composable
fun BerlinClockDisplay(modifier: Modifier, viewModel: ClockViewModel = viewModel()) {

	val clockState by viewModel.clockFlow.collectAsState()

	when (clockState) {
		is State.Loading -> {
			MessageDisplay(message = "Loading")
		}

		is State.Error -> {
			val throwable = (clockState as State.Error).throwable
			MessageDisplay(message = throwable.message ?: "An Error occurred")
		}

		is State.Success -> {
			val berlinClock = (clockState as State.Success).data
			Column(
				modifier = modifier
					.fillMaxSize()
					.padding(16.dp)
					.navigationBarsPadding()
					.statusBarsPadding(),
				verticalArrangement = Arrangement.SpaceBetween
			) {

				CircleLightBox(modifier = Modifier.weight(1f).padding(vertical = 4.dp), lightState = berlinClock.secondsLightState.first())

				LightRow(Modifier.weight(1f).padding(vertical = 4.dp), lightStates = berlinClock.upperHoursLightStates)

				LightRow(Modifier.weight(1f).padding(vertical = 4.dp), lightStates = berlinClock.lowerHoursLightStates)

				LightRow(Modifier.weight(1f).padding(vertical = 4.dp), lightStates = berlinClock.upperMinutesLightStates)

				LightRow(Modifier.weight(1f).padding(vertical = 4.dp), lightStates = berlinClock.lowerMinutesLightStates)

				Row(verticalAlignment = Alignment.Bottom) {
					ClockDisplay(modifier = modifier)
				}
			}
		}
	}
}

@Composable
fun MessageDisplay(message: String, modifier: Modifier = Modifier) {
	Column(
		modifier = modifier
			.fillMaxSize()
			.padding(16.dp),
		horizontalAlignment = Alignment.CenterHorizontally,
		verticalArrangement = Arrangement.Center
	) {
		Text(text = message)
	}
}

@Preview(showBackground = true)
@Composable
fun BerlinClockDisplayPreview() {
	BerlinClockTestTheme {
		BerlinClockDisplay(Modifier.padding(16.dp))
	}
}