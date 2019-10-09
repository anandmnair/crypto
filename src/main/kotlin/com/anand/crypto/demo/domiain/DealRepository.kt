package com.anand.crypto.demo.domiain

import com.anand.crypto.core.aspect.Decrypt
import com.anand.crypto.core.aspect.Encrypt
import java.util.*

interface DealRepository {
    @Encrypt
    fun save(deal: Deal) : Deal

    @Decrypt
    fun findAll(): List<Deal>

    @Decrypt
    fun findById(id:String) : Optional<Deal>
}