package com.anand.crypto.core

import com.anand.crypto.core.provider.UUIDProvider
import com.anand.crypto.core.repository.KeyStore
import com.anand.crypto.core.security.HashGenerator
import com.anand.crypto.core.provider.Clock
import mu.KotlinLogging
import javax.annotation.PostConstruct

private val logger = KotlinLogging.logger {}

class CryptoInitializer (
        private val keyProvider: KeyProvider,
        private val hashGenerator: HashGenerator,
        private val keyStore: KeyStore,
        private val uuidProvider: UUIDProvider,
        private val clock: Clock
) {

    @PostConstruct
    fun initialize() {
        val key = keyProvider.key()
        val hashKey = hashGenerator.hash(key)

        val keyMetadata = keyStore.findLastVersion()

        when {
            keyMetadata == null -> {
                logger.info { "No keys found!!! New key found." }
                keyStore.store(KeyMetadata(id = uuidProvider.id(), version = 1, hashKey = hashKey, createdOn = clock.now()))
            }

            keyMetadata.hashKey!=hashKey -> {
                logger.warn { "Key mismatch!!! New key found. Please make sure this will have an impact" }
                keyStore.store(KeyMetadata(id = uuidProvider.id(), version = (keyMetadata.version+1) , hashKey = hashKey, createdOn = clock.now()))
            }

            else -> {
                logger.info { "Key match found!!!" }
            }
        }
    }
}