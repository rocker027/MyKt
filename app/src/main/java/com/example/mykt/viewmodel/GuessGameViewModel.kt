package com.example.mykt.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.mykt.SecretNumber

class GuessGameViewModel : ViewModel() {
    private val secretNumber = SecretNumber()

    /**
     * live data
     */
    var mData = MutableLiveData<String>()

    /**
     * validate user input number
     * @param number (Int) input number
     * @return (Int)    > 0 is bigger to secretNumber ,
     *                  < 0 is smaller secretNumber ,
     *                  == 0 is answer
     */
    fun validateNumber(number: Int): String {
        return secretNumber.validate(number)
    }

    /**
     * reset secret number
     */
    fun resetSecretNumber() {
        secretNumber.reset()
    }

    /**
     * get live data

    viewModel.mData.observe(this, object : Observer<String> {
    override fun onChanged(t: String?) {
    println(t)
    }
    })


     */
    fun getData(): LiveData<String> {
        return mData
    }
}
