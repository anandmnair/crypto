package com.anand.crypto.demo

import com.anand.crypto.demo.domiain.Deal
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface DealJpaRepository : JpaRepository<Deal, String> {

}