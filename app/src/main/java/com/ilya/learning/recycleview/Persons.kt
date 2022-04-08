package com.ilya.learning.recycleview

import java.util.*

class Persons (var _id : UUID = UUID.randomUUID()){
    val id: UUID =_id
    var name: String = getRandomString(8)

    fun getRandomString(length: Int) : String {
        val charset = "ABCDEFGHIJKLMNOPQRSTUVWXTZabcdefghiklmnopqrstuvwxyz0123456789"
        return (1..length)
            .map { charset.random() }
            .joinToString("")
    }

}