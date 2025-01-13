package org.just_somebody.pocket_pixel

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform