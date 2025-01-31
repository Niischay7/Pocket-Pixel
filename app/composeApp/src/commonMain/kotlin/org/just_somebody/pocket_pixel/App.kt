package org.just_somebody.pocket_pixel

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.toRoute
import org.just_somebody.pocket_pixel.browseScreen.WowScreen
import org.just_somebody.pocket_pixel.core.Screens
import org.just_somebody.pocket_pixel.depInj.getNavController
import org.just_somebody.pocket_pixel.splashScreen.presentation.SplashScreen

@Composable
fun App()
{
  NavHost(
    navController     = getNavController(),
    startDestination  = Screens.SplashScreen
  )
  {
    composable<Screens.SplashScreen> { SplashScreen(); }
    composable<Screens.Wow>
    {
      val args = it.toRoute<Screens.Wow>()
      WowScreen(TEXT = args.TEXT);
    }
  }
}