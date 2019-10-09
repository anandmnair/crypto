package com.anand.crypto.core.security

import org.springframework.util.DigestUtils

class DefaultHashGenerator : HashGenerator {
    override fun hash(key: String): String {
        return DigestUtils.md5DigestAsHex(key.toByteArray())
    }
}