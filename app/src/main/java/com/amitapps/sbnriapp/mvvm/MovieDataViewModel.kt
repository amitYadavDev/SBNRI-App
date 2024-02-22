package com.amitapps.sbnriapp.mvvm

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.amitapps.sbnriapp.data.network.DataModel
import com.amitapps.sbnriapp.repository.VideoRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class MovieDataViewModel @Inject constructor(
    private val videoRepository: VideoRepository
) : ViewModel() {

    val movieResponseLiveData: LiveData<List<DataModel>>
        get() = videoRepository.movieResponseLiveData

    fun getMovieData() {
        viewModelScope.launch {
            videoRepository.getMovieData()
        }
    }
}