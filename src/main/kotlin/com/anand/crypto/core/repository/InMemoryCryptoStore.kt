package com.anand.crypto.core.repository

import com.anand.crypto.core.Crypto
import org.springframework.stereotype.Component

@Component
class InMemoryCryptoStore(private val store: MutableMap<String, Crypto> = mutableMapOf()) : CryptoStore {

    override fun store(crypto: Crypto): Crypto {
        store[crypto.entityMetadata.id] = crypto
        return crypto
    }

    override fun findByEntityId(entityId: String): Crypto? {
        return store[entityId]
    }

    override fun findAll(): Map<String, Crypto> {
        return store
    }
}