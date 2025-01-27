package org.just_somebody.pocket_pixel.splashScreen.data

import org.just_somebody.pocket_pixel.core.Result
import org.just_somebody.pocket_pixel.splashScreen.domain.Gamer
import org.just_somebody.pocket_pixel.core.networking.NetworkError

class SplashScreenNetworkCalls()
{
  fun connectToServer(GAMER : Gamer) : Result<Boolean, NetworkError>
  {
    // TODO("Connect to the server");
    return Result.Success(true);
  }
}