package com.hackaprende.basketballscore

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel: ViewModel() {
    var localScore: MutableLiveData<Int> = MutableLiveData()
    var visitorScore: MutableLiveData<Int> = MutableLiveData()

    init {
        resetScores()
    }

    fun resetScores() {
        localScore.value = 0
        visitorScore.value = 0
    }

    fun addPointsToScore(points: Int, isLocal: Boolean) {
        if (isLocal) {
            //Forma Anterior
            //localScore.value = localScore.value!! + points
            //Nueva forma
            localScore.value = localScore.value?.plus(points)
        } else {
            //visitorScore.value = localScore.value!! + points
            visitorScore.value = visitorScore.value?.plus(points)
        }
    }

    fun decreaseLocalScore(){
        if(localScore.value!! > 0){
            //Forma anterior
            //localScore.value = localScore.value!! - 1
            //Nueva forma
            localScore.value = localScore.value?.minus(1)
        }
    }

    fun decreaseVisitorScore(){
        if(visitorScore.value!! > 0){
            //Forma anterior
            //visitorScore.value = visitorScore.value!! - 1
            //Nueva forma
            visitorScore.value = visitorScore.value?.minus(1)
        }
    }


}

