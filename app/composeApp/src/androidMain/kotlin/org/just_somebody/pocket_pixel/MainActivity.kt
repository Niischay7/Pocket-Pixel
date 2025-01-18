package org.just_somebody.pocket_pixel

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview

class MainActivity : ComponentActivity()
{
    companion object
    {
        init
        {
            System.loadLibrary("pocketPixel")
        }
    }
  override fun onCreate(savedInstanceState: Bundle?)
  {
    super.onCreate(savedInstanceState)
    setContent ()
    {
        Column (modifier =  Modifier.fillMaxSize())
        {
            Text("Hello C++, this is Kotlin");
            Text(getCppGreeting());
            App();
        }
    }
  }
}

external fun getCppGreeting() : String;

