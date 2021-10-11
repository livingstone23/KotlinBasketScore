package com.hackaprende.basketballscore

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel: ViewModel() {
    private var _localScore: MutableLiveData<Int> = MutableLiveData()
    private var _visitorScore: MutableLiveData<Int> = MutableLiveData()

    val localScoreLiveData: LiveData<Int>
        get() = _localScore

    val visitorScoreLiveData: LiveData<Int>
        get() = _visitorScore

    init {
        resetScores()
    }

    fun resetScores() {
        _localScore.value = 0
        _visitorScore.value = 0
    }

    fun addPointsToScore(points: Int, isLocal: Boolean) {
        if (isLocal) {
            //Forma Anterior
            //localScore.value = localScore.value!! + points
            //Nueva forma
            _localScore.value = _localScore.value?.plus(points)
        } else {
            //visitorScore.value = localScore.value!! + points
            _visitorScore.value = _visitorScore.value?.plus(points)
        }
    }

    fun decreaseLocalScore(){
        if(_localScore.value!! > 0){
            //Forma anterior
            //localScore.value = localScore.value!! - 1
            //Nueva forma
            _localScore.value = _localScore.value?.minus(1)
        }
    }

    fun decreaseVisitorScore(){
        if(_visitorScore.value!! > 0){
            //Forma anterior
            //visitorScore.value = visitorScore.value!! - 1
            //Nueva forma
            _visitorScore.value = _visitorScore.value?.minus(1)
        }
    }


}

