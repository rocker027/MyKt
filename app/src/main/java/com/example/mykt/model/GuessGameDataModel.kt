package com.example.mykt.model

import androidx.lifecycle.MutableLiveData

data class GuessGameDataModel (
    var guessNumber : String ,
    var guessAnswer : Int ,
    var msgTitle : String ,
    var msgContent : String
)