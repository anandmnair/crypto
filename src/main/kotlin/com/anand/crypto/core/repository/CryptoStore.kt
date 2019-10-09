package com.anand.crypto.core.repository

import com.anand.crypto.core.Crypto

interface CryptoStore {
    fun store(crypto: Crypto) : Crypto
    fun findByEntityId(entityId:String):Crypto?
    fun findAll() : Map<String,Crypto>
}