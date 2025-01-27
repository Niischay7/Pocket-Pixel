package org.just_somebody.pocket_pixel.splashScreen.presentation

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember

import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import org.jetbrains.compose.resources.painterResource
import org.just_somebody.pocket_pixel.core.theme.GameBoyColors
import org.just_somebody.pocket_pixel.core.theme.PokeFontFamily
import org.just_somebody.pocket_pixel.splashScreen.domain.getGamerSessionStorage
import pocketpixel.composeapp.generated.resources.GameBoy
import pocketpixel.composeapp.generated.resources.Res


@Composable
fun SplashScreen(
  NAV_TO_HOME  : () -> Unit       = {},
  MODIFIER     : Modifier         = Modifier,
  VIEW_MODEL   : SplashViewModel  = SplashViewModel()
)
{
  val state   = VIEW_MODEL.state
  LaunchedEffect(Unit) { VIEW_MODEL.onAction(SplashActions.AutoLogin) }


  Box(
    modifier = MODIFIER
      .fillMaxSize()
      .background(GameBoyColors.DarkGreen)
  )
  {
    Image(
      painter             = painterResource(Res.drawable.GameBoy),
      contentDescription  = null,
      modifier            = Modifier
                      .align(Alignment.Center)
                      .size(200.dp)
    )
  }
}