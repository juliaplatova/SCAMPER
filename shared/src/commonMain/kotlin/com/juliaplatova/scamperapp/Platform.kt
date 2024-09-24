package com.juliaplatova.scamperapp

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform