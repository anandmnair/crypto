package com.anand.crypto.demo

import com.anand.crypto.demo.domiain.Deal
import com.anand.crypto.demo.domiain.DealRepository
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/v1/deals")
class DealApi(val dealRepository: DealRepository) {

    @GetMapping()
    fun getAll(): List<Deal> {
        println("Api - Get All : ")
        return dealRepository.findAll()
    }

    @PostMapping()
    fun save(@RequestBody deal: Deal): Deal {
        println("Api - Get Sav : ")
        return dealRepository.save(deal)
    }

    @GetMapping("/{id}")
    fun getById(@PathVariable("id") id:String): Deal? {
        println("Api - Get By Id : ")
        return dealRepository.findById(id).get()
    }


}