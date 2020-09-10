package com.example.premierleageapp.ui.main

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import com.example.premierleageapp.Api.PremierLeague
import com.example.premierleageapp.model.RepoPremier

class MainViewModel(application: Application) : AndroidViewModel(application) {

    private val mRepoPremier = RepoPremier(application)
    fun mGetData() {
        mRepoPremier.fetchDataFromServer()
    }

    fun mGetListFromViewModel(): LiveData<List<PremierLeague>> {
        return mRepoPremier.getListFromRepoPremier()
    }
}