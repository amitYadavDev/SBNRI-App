package com.amitapps.sbnriapp.data.network

import com.amitapps.sbnriapp.utils.Constants.API_END_POINT
import okhttp3.Response
import retrofit2.http.GET

// defined api end-point
interface MovieApi {
    @GET(API_END_POINT)
    suspend fun getMovieData(): List<DataModel>
}