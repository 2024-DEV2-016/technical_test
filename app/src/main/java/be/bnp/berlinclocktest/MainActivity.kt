package be.bnp.berlinclocktest

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import be.bnp.berlinclocktest.ui.BerlinClockDisplay
import be.bnp.berlinclocktest.ui.theme.BerlinClockTestTheme

class MainActivity : ComponentActivity() {
	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		enableEdgeToEdge()
		setContent {
			BerlinClockTestTheme {
				Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
					BerlinClockDisplay(modifier = Modifier)
				}
			}
		}
	}
}