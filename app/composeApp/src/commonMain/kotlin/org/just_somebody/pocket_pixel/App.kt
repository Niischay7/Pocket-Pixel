package org.just_somebody.pocket_pixel

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.resources.DrawableResource
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
      Button(onClick = { showContent = !showContent }) 
      {
        Text("Just Some Button")
      }

      // - - - display an image and the greeting for platform we are running from
      AnimatedVisibility(showContent) 
      {
        val greeting = remember { Greeting().greet() }
        Column(
          Modifier.fillMaxWidth(), 
          horizontalAlignment = Alignment.CenterHorizontally) 
        {
          Image(painterResource(Res.drawable.GameBoy), null)
          Text("Just Somebody: $greeting")
        }
      }
    }
  }
}
