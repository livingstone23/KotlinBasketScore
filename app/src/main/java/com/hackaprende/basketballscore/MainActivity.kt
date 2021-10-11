package com.hackaprende.basketballscore

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.hackaprende.basketballscore.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding


    //Utilizando el viewmodel
    private lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)

        //Para obtener los valores del viewModel localscore
        viewModel.localScoreLiveData.observe(this, Observer {
            localScoreValue ->
            binding.localScoreText.text = localScoreValue.toString()
        })

        //Para obtener los valores del viewmodel Visitante
        viewModel.visitorScoreLiveData.observe(this, Observer {
            visitorScoreValue ->
            binding.visitorScoreText.text = visitorScoreValue.toString()
        })


        setupButtons()
    }

    private fun setupButtons() {
        binding.localMinusButton.setOnClickListener {
           viewModel.decreaseLocalScore()

        }

        binding.localPlusButton.setOnClickListener {
            addPointsToScore(1, isLocal = true)
        }

        binding.localTwoPointsButton.setOnClickListener {
            addPointsToScore(2, isLocal = true)
        }

        binding.visitorMinusButton.setOnClickListener {
                viewModel.decreaseVisitorScore()
        }

        binding.visitorPlusButton.setOnClickListener {
            addPointsToScore(1, isLocal = false)
        }

        binding.visitorTwoPointsButton.setOnClickListener {
            addPointsToScore(2, isLocal = false)
        }

        binding.restartButton.setOnClickListener {
            viewModel.resetScores()
        }

        binding.resultsButton.setOnClickListener {
            startScoreActivity()
        }
    }


    private fun addPointsToScore(points: Int, isLocal: Boolean) {

        viewModel.addPointsToScore(points, isLocal)

    }

    private fun startScoreActivity() {
        val intent = Intent(this, ScoreActivity::class.java)
        intent.putExtra(ScoreActivity.LOCAL_SCORE_KEY, viewModel.localScoreLiveData.value)
        intent.putExtra(ScoreActivity.VISITOR_SCORE_KEY, viewModel.visitorScoreLiveData.value)
        startActivity(intent)
    }


}