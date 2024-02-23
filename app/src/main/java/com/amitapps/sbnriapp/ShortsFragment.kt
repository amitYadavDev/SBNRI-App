package com.amitapps.sbnriapp

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.viewModels
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import com.amitapps.sbnriapp.databinding.FragmentShortsBinding
import com.amitapps.sbnriapp.mvvm.MovieDataViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ShortsFragment : Fragment() {
    private lateinit var shortsAdapter: MovieAdapter

    private lateinit var binding: FragmentShortsBinding


    private val movieDataViewModel by viewModels<MovieDataViewModel>()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentShortsBinding.inflate(inflater, container, false)
        binding.lifecycleOwner = viewLifecycleOwner
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        movieDataViewModel.getMovieData()
        Log.d("movieDataViewModelHorizontal", "  yeah")



        movieDataViewModel.movieResponseLiveData.observe(requireActivity(), Observer {movieData->
            Log.d("movieDataViewModelHorizontal", movieData.toString())
            binding.horizontalRecyclerView.apply {
                val response = movieData
                shortsAdapter = MovieAdapter(response)
                adapter = shortsAdapter
            }
        })
    }

}