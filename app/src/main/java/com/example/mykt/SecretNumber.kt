package com.example.mykt

import java.util.*

class SecretNumber {
    private var secretNumber : Int = Random().nextInt(10) + 1
    private var count = 0

    /**
     * @param number (int) input number
     * @return secretNumber different value
     */
    fun validate(number : Int) : Int {
        count ++
        println("secret number : ${secretNumber} , coout : ${count}")
        return number - secretNumber
    }

    fun reset() {
        secretNumber = Random().nextInt(10)+1
        count = 0
    }

}