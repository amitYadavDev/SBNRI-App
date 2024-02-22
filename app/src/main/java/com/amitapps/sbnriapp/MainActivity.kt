package com.amitapps.sbnriapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import com.amitapps.sbnriapp.mvvm.MovieDataViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private val movieDataViewModel by viewModels<MovieDataViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        movieDataViewModel.getMovieData()

//        Log.d("movieDataViewModel", movieDataViewModel.movieResponseLiveData.)

        movieDataViewModel.movieResponseLiveData.observe(this, Observer {
            Log.d("movieDataViewModel", it.toString())
        })
    }
}