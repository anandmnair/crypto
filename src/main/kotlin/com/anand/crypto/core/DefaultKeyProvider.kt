package com.anand.crypto.core

class DefaultKeyProvider(private val key:String): KeyProvider {
    override fun key(): String {
        return key
    }
}

