package com.example.mykt.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.mykt.SecretNumber
import com.example.mykt.model.GuessGameDataModel
import com.example.mykt.utils.ANSWER
import com.example.mykt.utils.BIGGER
import com.example.mykt.utils.SMALLER

class GuessGameViewModel : ViewModel() {
    private val secretNumber = SecretNumber()
    val guessNumberLiveData = MutableLiveData<String>()
    val isShowDailog = MutableLiveData<Boolean>()
    var dataModel = GuessGameDataModel("",0,"","")
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
        isShowDailog.value = false
    }

    /**
     * get live data

    viewModel.mData.observe(this, object : Observer<String> {
    override fun onChanged(t: String?) {
    println(t)
    }
    })


     */


    fun checkResult() {
        dataModel.guessAnswer = secretNumber.getNumber()

        val input = guessNumberLiveData.value

        if (input.isNullOrEmpty()) {
            dataModel.guessNumber = ""
            dataModel.msgTitle = "Error"
            dataModel.msgContent = "Please input number"
            isShowDailog.value = true
            return
        }

        var diff = input.let {
            validateNumber(it.toInt())
        }

        when (diff) {
            BIGGER -> {
                dataModel.guessNumber = ""
                guessNumberLiveData.value = ""
                dataModel.msgTitle = "Message"
                dataModel.msgContent = "Bigger"
                isShowDailog.value = true
            }
            SMALLER -> {
                dataModel.guessNumber = ""
                guessNumberLiveData.value = ""
                dataModel.msgContent = "Smaller"
                dataModel.msgTitle = "Message"
                isShowDailog.value = true
            }
            ANSWER -> {
                dataModel.guessNumber = ""
                guessNumberLiveData.value = ""
                dataModel.msgTitle = "Congratulations"
                dataModel.msgContent = "You win"
                isShowDailog.value = true
                resetSecretNumber()
            }
            else -> {
                return
            }
        }

    }
}
