package com.amitapps.sbnriapp.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.amitapps.sbnriapp.R
import com.amitapps.sbnriapp.databinding.ActivityMainBinding
import com.amitapps.sbnriapp.mvvm.MovieDataViewModel
import com.amitapps.sbnriapp.ui.adapters.MovieAdapter
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private val movieDataViewModel by viewModels<MovieDataViewModel>()

    private lateinit var managerVertical: RecyclerView.LayoutManager

    private lateinit var managerHorizontal: RecyclerView.LayoutManager

    private var _binding: ActivityMainBinding? = null
    private val binding get() = _binding!!


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // getting data from api
        movieDataViewModel.getMovieData()

        managerVertical =  LinearLayoutManager(this)
        managerHorizontal = LinearLayoutManager(this)

        // fragment for shorts
        loadFragment(ShortsFragment(), R.id.shortsFragment)

//        Log.d("movieDataViewModel", movieDataViewModel.movieResponseLiveData.)

        // setting data to vertical recyclerview
        movieDataViewModel.movieResponseLiveData.observe(this, Observer {movieData->
            Log.d("movieDataViewModel", movieData.toString())
            binding.verticalRecyclerView.apply {
                val response = movieData
                adapter = MovieAdapter(response)
                layoutManager = managerVertical
                adapter = adapter
            }
        })
    }

    private fun loadFragment(fragment: Fragment, containerId: Int) {
        supportFragmentManager.beginTransaction()
            .replace(containerId, fragment)
            .commit()
    }
}