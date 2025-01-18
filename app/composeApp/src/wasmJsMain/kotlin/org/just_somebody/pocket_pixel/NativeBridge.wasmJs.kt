package org.just_somebody.pocket_pixel

import org.khronos.webgl.ArrayBuffer
import org.khronos.webgl.Int8Array
import org.khronos.webgl.get

@JsName("getNativeFrame")
external fun getNativeFrame(BUFFER : ArrayBuffer)

class JsNativeBridge : NativeBridge()
{
  override val platformName: String
    get() = "Web"

  override fun getFrame(BUFFER: ByteArray)
  {
    // - - - Worship the gods : Khronos Group
    val arrayBuffer = ArrayBuffer(BUFFER.size)

    getNativeFrame(arrayBuffer)

    // - - - Copy the ArrayBuffer data into the ByteArray
    val int8Array = Int8Array(arrayBuffer)
    for (index in BUFFER.indices)
    {
      BUFFER[index] = int8Array[index]
    }
  }
}

actual fun getNativeBridge(): NativeBridge = JsNativeBridge()