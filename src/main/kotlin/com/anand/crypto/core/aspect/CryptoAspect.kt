package com.anand.crypto.core.aspect

import com.anand.crypto.core.Crypto
import com.anand.crypto.core.EntityMetadata
import com.anand.crypto.core.provider.UUIDProvider
import com.anand.crypto.core.repository.CryptoStore
import com.anand.crypto.core.repository.KeyStore
import com.anand.crypto.demo.domiain.Deal
import org.aspectj.lang.ProceedingJoinPoint
import org.aspectj.lang.annotation.Around
import org.aspectj.lang.annotation.Aspect
import org.springframework.context.annotation.EnableAspectJAutoProxy
import org.springframework.stereotype.Component
import java.util.*


@EnableAspectJAutoProxy
@Component
@Aspect
class CryptoAspect(val keyStore: KeyStore, val cryptoStore: CryptoStore, val uuidProvider: UUIDProvider) {

    @Around("@annotation(com.anand.crypto.core.aspect.Encrypt)")
    fun encrypt(joinPoint : ProceedingJoinPoint) : Any  {
        println("@Around: Before encrypt-"+  Date())
        val deal = joinPoint.args[0] as Deal
        val encryptDeal = Deal(id =  deal.id, name = deal.name, code = deal.code, client = encrypt(deal.client), amount = deal.amount)
        joinPoint.args[0] = encryptDeal
        //var crypto = cryptoStore.findByEntityId(deal.id)
        val result = joinPoint.proceed( joinPoint.args )
        val keyMetadata = keyStore.findLastVersion()!!
        cryptoStore.store(Crypto(
                id=uuidProvider.id(),
                entityMetadata = EntityMetadata(name = "DEAL", id = deal.id, columns = setOf(deal.client)),
                keyMetadata = keyMetadata))
        println("@Around: After encrypt-"+  Date())
        return  result
    }

    @Around("@annotation(com.anand.crypto.core.aspect.Decrypt)")
    fun decrypt(joinPoint : ProceedingJoinPoint) : Any  {
        println("@Around: Before decrypt-"+  Date())
        var result = joinPoint.proceed()

        //cryptoStore.findByEntityId()
        when(result) {
            is Deal -> {
                result = Deal(id =  result.id, name = result.name, code = result.code, client = decrypt(result.client), amount = result.amount)
            }

            is Optional<*> -> {
                if(result.isPresent) {
                    val deal = result.get() as Deal
                    result = Optional.of(
                            Deal(id =  deal.id, name = deal.name, code = deal.code, client = decrypt(deal.client), amount = deal.amount)
                    )
                }
            }
        }
        println("@Around: After decrypt-"+  Date())
        return  result
    }

    private fun encrypt(value:String) : String {
        return "ENC($value)"
    }

    private fun decrypt(value:String) : String {
        return value.substring(4,value.lastIndex)
    }
}