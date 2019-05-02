package com.example.mykt

import com.example.mykt.utils.ANSWER
import com.example.mykt.utils.BIGGER
import com.example.mykt.utils.SMALLER
import java.util.*

class SecretNumber {
    private var secretNumber : Int = Random().nextInt(10) + 1
    private var count = 0

    /**
     * @param number (int) input number
     * @return secretNumber different value
     */
    fun validate(number : Int) : String {
        count ++
        println("secret number : ${secretNumber} , coout : ${count}")
        var diff = number - secretNumber
        if (diff > 0 ) {
            return BIGGER
        }else if (diff < 0) {
            return SMALLER
        } else {
            return ANSWER
        }
    }

    fun reset() {
        secretNumber = Random().nextInt(10)+1
        count = 0
    }

}