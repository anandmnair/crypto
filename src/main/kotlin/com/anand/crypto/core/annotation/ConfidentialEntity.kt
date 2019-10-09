package com.anand.crypto.core.annotation

@Target(AnnotationTarget.CLASS)
@Retention(AnnotationRetention.RUNTIME)
@MustBeDocumented
annotation class ConfidentialEntity(val id: Array<String>) {
}