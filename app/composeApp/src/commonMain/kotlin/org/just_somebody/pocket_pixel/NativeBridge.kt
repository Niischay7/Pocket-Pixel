package org.just_somebody.pocket_pixel

abstract class NativeBridge
{
  abstract val platformName                       : String;
  abstract fun getFrame(BUFFER : ByteArray)       : Unit
}

expect fun getNativeBridge(): NativeBridge;