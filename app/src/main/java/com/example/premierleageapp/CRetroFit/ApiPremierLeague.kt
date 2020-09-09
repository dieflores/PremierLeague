package com.example.premierleageapp.CRetroFit

import com.example.premierleageapp.Api.PremierLeague
import retrofit2.Call
import retrofit2.http.*

interface ApiPremierLeague {

    @GET("")

    fun GetAllPremierLeague(): Call<List<PremierLeague>>

    @DELETE("")
    fun deletePremierLeague(@Path("") title: String?): Call<Void>

    @POST("")
    fun createNewMatchPremierLeague(@Body premierLeague: PremierLeague): Call<PremierLeague>
}
