package com.anand.crypto.demo.domiain

import com.anand.crypto.core.annotation.ConfidentialEntity
import com.anand.crypto.core.annotation.ConfidentialField
import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.Table

@ConfidentialEntity(id = ["sss", "sss"])
@Entity
@Table(name = "T_Deal")
data class Deal(

        @Id
        val id:String,

        val code:String,

        val name:String,

        @ConfidentialField
        val client:String,

        val amount:Int
)