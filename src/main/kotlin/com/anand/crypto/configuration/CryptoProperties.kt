package com.anand.crypto.configuration

import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.boot.context.properties.EnableConfigurationProperties
import org.springframework.stereotype.Component

@EnableConfigurationProperties
@Component
@ConfigurationProperties(prefix = "crypto")
class CryptoProperties() {

    var enabled:Boolean = true

    lateinit var  key:String

}