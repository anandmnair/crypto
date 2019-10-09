package com.anand.crypto.core

import java.time.LocalDateTime

data class KeyMetadata(val id:String , val version:Int, val hashKey:String, val createdOn: LocalDateTime)