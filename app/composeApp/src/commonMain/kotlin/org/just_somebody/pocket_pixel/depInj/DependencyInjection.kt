package org.just_somebody.pocket_pixel.depInj

import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import org.just_somebody.pocket_pixel.splashScreen.data.SplashScreenNetworkCalls

private val splashNetCalls = SplashScreenNetworkCalls()
private var navController : NavHostController? = null;

fun getSplashNetworkCalls() : SplashScreenNetworkCalls { return splashNetCalls; }

@Composable
fun getNavController() : NavHostController
{
  if (navController == null) navController = rememberNavController()
  return navController as NavHostController;
}
