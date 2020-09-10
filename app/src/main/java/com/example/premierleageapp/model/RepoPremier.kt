package com.example.premierleageapp.model

import android.content.Context
import android.util.Log
import androidx.lifecycle.LiveData
import com.example.premierleageapp.Api.PremierLeague
import com.example.premierleageapp.Bdatabase.RoomDataBasePremier
import com.example.premierleageapp.CRetroFit.ApiPremierLeague
import com.example.premierleageapp.CRetroFit.RetroFitClient
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class RepoPremier(context: Context) {

    private val dataBase: RoomDataBasePremier = RoomDataBasePremier
        .getDataBase(context)
    private val premierLeagueList = dataBase.getPremierLeagueDao()
        .getAllMatchesPremierLeague()
    private val tag = "PremierLeague Repository"

    fun getListFromRepoPremier(): LiveData<List<PremierLeague>> {
        return premierLeagueList
    }

    fun fetchDataFromServer() {
        val service: ApiPremierLeague = RetroFitClient.retrofitInstance()
        val call: Call<List<PremierLeague>> = service.GetAllPremierLeague()

        call.enqueue(object : Callback<List<PremierLeague>> {
            override fun onResponse(
                call: Call<List<PremierLeague>>,
                response: Response<List<PremierLeague>>
            ) {
                Log.d("REPO REVISANDO", response.body().toString())

                CoroutineScope(Dispatchers.IO).launch {
                    response.body()?.let {
                        dataBase.getPremierLeagueDao()
                            .insertAllMatchesPremierLeague(it)
                    }
                }
            }

            override fun onFailure(call: Call<List<PremierLeague>>, t: Throwable) {
                Log.e("ERROR RETROFIT", t.message.toString())
            }

        })
    }

}