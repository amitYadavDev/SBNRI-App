package com.amitapps.sbnriapp.repository

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.amitapps.sbnriapp.data.network.DataModel
import com.amitapps.sbnriapp.data.network.MovieApi
import javax.inject.Inject

class VideoRepository @Inject constructor(private val movieApi: MovieApi) {

    private val _movieResponseLiveData = MutableLiveData<List<DataModel>>()
    val movieResponseLiveData: LiveData<List<DataModel>>
        get() = _movieResponseLiveData

    suspend fun getMovieData() {
        var response = movieApi.getMovieData()
        for(res in 1..5) response += response
        _movieResponseLiveData.postValue(response)
    }
}