package com.anand.crypto.demo

import com.anand.crypto.core.Crypto
import com.anand.crypto.core.KeyMetadata
import com.anand.crypto.core.repository.CryptoStore
import com.anand.crypto.core.repository.KeyStore
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController


@RestController
@RequestMapping("/api/v1")
class CryptoApi(val keyStore: KeyStore, val cryptoStore: CryptoStore) {

    @GetMapping("/keys")
    fun getAll(): List<KeyMetadata> {
        return keyStore.findAll()
    }

    @GetMapping("/cryptos")
    fun getAllCrypto(): Map<String, Crypto> {
        return cryptoStore.findAll()
    }

}