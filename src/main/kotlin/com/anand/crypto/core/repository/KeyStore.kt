package com.anand.crypto.core.repository

import com.anand.crypto.core.KeyMetadata

interface KeyStore {
    fun store(keyMetadata: KeyMetadata) : KeyMetadata
    fun findLastVersion(): KeyMetadata?
    fun findAll(): List<KeyMetadata>
}