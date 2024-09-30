package com.homebridge.app_sem7_challenge_friends.network

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface RandomUserApiService {
    @GET("/api/")
    fun getUsers(@Query("results") results: Int): Call<ApiResponse>
}