package org.just_somebody.pocket_pixel

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import org.just_somebody.pocket_pixel.splashScreen.depInj.setContext


class MainActivity : ComponentActivity()
{
  override fun onCreate(savedInstanceState: Bundle?)
  {
    enableEdgeToEdge()
    super.onCreate(savedInstanceState)
    setContext(applicationContext);
    setContent { App(); }
  }
}