package com.anand.crypto.core.provider

import org.springframework.stereotype.Component
import java.time.LocalDateTime

@Component
class Clock {
    fun now():LocalDateTime {
        return LocalDateTime.now()
    }
}