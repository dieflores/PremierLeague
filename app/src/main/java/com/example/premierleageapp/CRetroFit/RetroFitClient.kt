package com.example.premierleageapp.CRetroFit

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetroFitClient {

    companion object{

        private const val BASE_URL = "https://www.scorebat.com/video-api/v1/"
        fun retrofitInstance(): ApiPremierLeague{
            val retrofit : Retrofit = Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
            return retrofit.create(ApiPremierLeague::class.java)
        }
    }
}