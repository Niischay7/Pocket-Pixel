package org.just_somebody.pocket_pixel

class Greeting {
    private val platform = getPlatform()

    fun greet(): String {
        return "Pixel Pocket on, ${platform.name}!"
    }
}