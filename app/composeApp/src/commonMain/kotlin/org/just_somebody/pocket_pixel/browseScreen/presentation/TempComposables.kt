package org.just_somebody.pocket_pixel.browseScreen.presentation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color

@Composable
fun temp(modifier: Modifier = Modifier)
{
  Text("New Screen", modifier = modifier.fillMaxSize().background(Color.Red))
}