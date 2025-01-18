package org.just_somebody.pocket_pixel

actual fun getNativeBridge(): NativeBridge = AndroidNativeBridge()

class AndroidNativeBridge : NativeBridge()
{
  override val platformName: String
    get() = "Android"

  override fun getFrame(BUFFER : ByteArray): Unit
  {
    return getNativeFrame(BUFFER)
  }

  private external fun getNativeFrame(BUFFER : ByteArray) : Unit

  companion object
  {
    init { System.loadLibrary("pocketPixel") }
  }
}
