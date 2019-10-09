package com.anand.crypto.core.security

interface HashGenerator {
    fun hash(key:String):String
}