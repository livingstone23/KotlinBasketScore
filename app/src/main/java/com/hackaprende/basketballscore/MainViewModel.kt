package com.hackaprende.basketballscore

import androidx.lifecycle.ViewModel

class MainViewModel: ViewModel() {
    public var localScore = 0
    public var visitorScore = 0

    fun resetScores() {
        localScore = 0
        visitorScore = 0
    }

    fun addPointsToScore(points: Int, isLocal: Boolean) {
        if (isLocal) {
            localScore += points
        } else {
            visitorScore += points
        }
    }

    fun decreaseLocalScore(){
        if(localScore > 0){
            localScore--
        }
    }

    fun decreaseVisitorScore(){
        if(visitorScore > 0){
            visitorScore--
        }
    }




}

