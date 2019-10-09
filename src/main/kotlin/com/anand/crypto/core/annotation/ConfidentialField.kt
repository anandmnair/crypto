package com.anand.crypto.core.annotation

import com.anand.crypto.core.Level


@Target(AnnotationTarget.FIELD, AnnotationTarget.PROPERTY)
@Retention(AnnotationRetention.RUNTIME)
@MustBeDocumented
annotation class ConfidentialField(val value: Level = Level.HIGH) {

}