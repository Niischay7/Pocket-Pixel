package org.just_somebody.pocket_pixel.depInj

import org.just_somebody.pocket_pixel.splashScreen.data.SplashScreenNetworkCalls

private val splashNetCalls = SplashScreenNetworkCalls()

fun getSplashNetworkCalls() : SplashScreenNetworkCalls
{
  return splashNetCalls;
}
