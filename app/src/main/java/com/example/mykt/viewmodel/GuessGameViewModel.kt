package com.example.mykt.viewmodel

import androidx.lifecycle.ViewModel;
import com.example.mykt.SecretNumber

class GuessGameViewModel : ViewModel() {
    private val secretNumber = SecretNumber()

    /**
     * validate user input number
     * @param number (Int) input number
     * @return (Int)    > 0 is bigger to secretNumber ,
     *                  < 0 is smaller secretNumber ,
     *                  == 0 is answer
     */
    fun validateNumber(number: Int): Int {
        return secretNumber.validate(number)
    }

    /**
     * reset secret number
     */
    fun resetSecretNumber() {
        secretNumber.reset()
    }
}
