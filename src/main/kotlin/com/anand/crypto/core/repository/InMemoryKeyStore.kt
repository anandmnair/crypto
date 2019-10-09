package com.anand.crypto.core.repository

import com.anand.crypto.core.KeyMetadata
import org.springframework.stereotype.Component

@Component
class InMemoryKeyStore(private val store:MutableList<KeyMetadata> = mutableListOf()) : KeyStore {

    override fun store(keyMetadata: KeyMetadata): KeyMetadata {
        store.add(keyMetadata)
        return keyMetadata
    }

    override fun findLastVersion(): KeyMetadata? {
        return store.lastOrNull()
    }

    override fun findAll() : List<KeyMetadata> {
        return store
    }
}