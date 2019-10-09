package com.anand.crypto.core.provider

import org.springframework.stereotype.Component
import java.util.*

@Component
class UUIDProvider {
    fun id(): String {
        return UUID.randomUUID().toString()
    }
}