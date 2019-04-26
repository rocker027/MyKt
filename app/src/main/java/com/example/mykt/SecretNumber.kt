package com.example.mykt

import java.util.*

class SecretNumber {
    val secretNumber : Int = Random().nextInt(10) + 1
    var count = 0

    /**
     * @param number (int) input number
     * @return secretNumber different value
     */
    fun validate(number : Int) : Int {
        count ++
        return number - secretNumber
    }

}

fun main() {
    val serectNumber = SecretNumber()
    println(serectNumber.secretNumber)
    println("${serectNumber.validate(5)}, coout : ${serectNumber.count}")
}