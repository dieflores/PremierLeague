package com.example.premierleageapp.ui.main

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.premierleageapp.AdapterPremierLeague
import com.example.premierleageapp.Api.PremierLeague
import com.example.premierleageapp.R
import kotlinx.android.synthetic.main.main_fragment.*

class MainFragment : Fragment() {

    lateinit var mAdapterPremierLeague: AdapterPremierLeague

    companion object {
        fun newInstance() = MainFragment()
    }

    private lateinit var viewModel: MainViewModel
    private lateinit var lista: List<PremierLeague>

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(R.layout.main_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this)
            .get(MainViewModel::class.java)
        lista = ArrayList()
        mAdapterPremierLeague = AdapterPremierLeague(lista)
        viewModel.mGetData()

        reciclerViewPremierLeague.adapter = mAdapterPremierLeague
        reciclerViewPremierLeague.layoutManager = LinearLayoutManager(context)
        // LiveData
        viewModel.mGetListFromViewModel().observe(viewLifecycleOwner, Observer {
            Log.d("AQUI ESTAN LOS DATOS", it.toString())
            mAdapterPremierLeague.updateData(it)
        })

    }

}