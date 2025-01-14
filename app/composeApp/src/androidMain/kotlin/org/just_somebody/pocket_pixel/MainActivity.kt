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
            System.loadLibrary("pocket_pixel")
        }
    }
  override fun onCreate(savedInstanceState: Bundle?)
  {
    super.onCreate(savedInstanceState)
    setContent ()
    {
        Column (modifier =  Modifier.fillMaxSize())
        {
          callCpp();
            Text("Hello C++, this is Kotlin");
            Text("Int from C++ ${getCppInt()}")
            Text(getCppGreeting());
            App();
        }
    }
  }
}

external fun getCppGreeting() : String;

external fun callCpp() : Unit

external fun getCppInt() : Int

@Preview
@Composable
fun AppAndroidPreview()
{
    Column (modifier =  Modifier.fillMaxSize())
    {
        Text("Hello C++, this is Kotlin");
        App();
    }
}