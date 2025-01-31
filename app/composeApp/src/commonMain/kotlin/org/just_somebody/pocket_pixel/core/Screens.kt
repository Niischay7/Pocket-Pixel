package org.just_somebody.pocket_pixel.core

import kotlinx.serialization.Serializable

sealed interface Screens
{
  @Serializable
  data object SplashScreen : Screens

  @Serializable
  data class Wow(val TEXT : String) : Screens
}