package com.amitapps.sbnriapp.ui

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import com.amitapps.sbnriapp.databinding.FragmentShortsBinding
import com.amitapps.sbnriapp.mvvm.MovieDataViewModel
import com.amitapps.sbnriapp.ui.adapters.ShortsAdapter
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ShortsFragment : Fragment() {
    private lateinit var shortsAdapter: ShortsAdapter

    private lateinit var binding: FragmentShortsBinding

    // share data via activity to fragment
    private val viewModel: MovieDataViewModel by activityViewModels()

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
        Log.d("movieDataViewModelHorizontal", "  yeah")


        // recyclerview for vertical data
        viewModel.movieResponseLiveData.observe(requireActivity(), Observer {movieData->
            Log.d("movieDataViewModelHorizontal", movieData.toString())
            binding.horizontalRecyclerView.apply {
                val response = movieData
                shortsAdapter = ShortsAdapter(response)
                adapter = shortsAdapter
            }
        })
    }
}