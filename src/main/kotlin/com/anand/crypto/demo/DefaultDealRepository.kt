package com.anand.crypto.demo

import com.anand.crypto.core.aspect.Decrypt
import com.anand.crypto.core.aspect.Encrypt
import com.anand.crypto.demo.domiain.Deal
import com.anand.crypto.demo.domiain.DealRepository
import org.springframework.stereotype.Component
import java.util.*

@Component
class DefaultDealRepository(private val dealJpaRepository: DealJpaRepository) : DealRepository {
    @Encrypt
    override fun save(deal: Deal): Deal {
        return dealJpaRepository.save(deal)
    }

    @Decrypt
    override fun findAll(): List<Deal> {
        return dealJpaRepository.findAll()
    }

    @Decrypt
    override fun findById(id: String): Optional<Deal> {
        return dealJpaRepository.findById(id)
    }

}