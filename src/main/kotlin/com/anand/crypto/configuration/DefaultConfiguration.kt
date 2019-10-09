package com.anand.crypto.configuration

import com.anand.crypto.core.CryptoInitializer
import com.anand.crypto.core.DefaultKeyProvider
import com.anand.crypto.core.KeyProvider
import com.anand.crypto.core.provider.Clock
import com.anand.crypto.core.provider.UUIDProvider
import com.anand.crypto.core.repository.KeyStore
import com.anand.crypto.core.security.DefaultHashGenerator
import com.anand.crypto.core.security.HashGenerator
import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class DefaultConfiguration {

    @Bean
    fun keyProvider(@Value("\${crypto.key}") key:String) : KeyProvider {
        return DefaultKeyProvider(key=key)
    }

    @Bean
    fun hashGenerator(): HashGenerator {
        return DefaultHashGenerator()
    }

    @Bean
    fun cryptoInitializer(keyProvider: KeyProvider, hashGenerator: HashGenerator,  keyStore: KeyStore,uuidProvider: UUIDProvider,clock: Clock) : CryptoInitializer {
        return CryptoInitializer(keyProvider, hashGenerator, keyStore, uuidProvider, clock)
    }
}