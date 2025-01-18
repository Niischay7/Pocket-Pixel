package org.just_somebody.pocket_pixel

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.ui.tooling.preview.Preview
import pocketpixel.composeapp.generated.resources.GameBoy
import pocketpixel.composeapp.generated.resources.Res


@Composable
@Preview
fun App() 
{
  MaterialTheme () 
  {
    // - - - decide whether or not to show something
    var showContent by remember { mutableStateOf(false) }

    // - - - the content arrange in a column
    Column(
      Modifier.fillMaxWidth(), 
      horizontalAlignment = Alignment.CenterHorizontally) 
    {
      Image(painterResource(Res.drawable.GameBoy), null);
      GameScreen();
    }
  }
}

@Composable
fun GameScreen()
{
  val display = remember { GameBoyDisplay() }
  val platformName = display.bridge.platformName;

  Column()
  {
    Text("Running on: $platformName")
    display.render()
  }
}