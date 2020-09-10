package com.example.premierleageapp.CRetroFit

import com.example.premierleageapp.Api.PremierLeague
import retrofit2.Call
import retrofit2.http.GET

interface ApiPremierLeague {

    @GET("v1/")
    fun GetAllPremierLeague(): Call<List<PremierLeague>>

}
