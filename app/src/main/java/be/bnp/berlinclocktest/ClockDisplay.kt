package be.bnp.berlinclocktest

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import be.bnp.berlinclocktest.ui.theme.BerlinClockTestTheme

@Composable
fun ClockDisplay(modifier: Modifier, viewModel: ClockViewModel = viewModel()) {

	val currentTime by viewModel.timeFlow.collectAsState()

	Row(modifier = modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Center) {
		Text(
			modifier = Modifier.testTag("clock"),
			text = stringResource(R.string.date_format, currentTime.hour, currentTime.minute, currentTime.second),
			fontSize = 50.sp
		)
	}
}

@Composable
@Preview
fun ClockDisplayPreview() {
	BerlinClockTestTheme {
		ClockDisplay(modifier = Modifier)
	}
}