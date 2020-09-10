package com.example.premierleageapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.premierleageapp.Api.PremierLeague
import kotlinx.android.synthetic.main.item_list_view_holder.view.*

class AdapterPremierLeague(var dataSetPremierLeague: List<PremierLeague>) :
    RecyclerView.Adapter<AdapterPremierLeague.ViewHolderPremierLeague>() {

    fun updateData(list: List<PremierLeague>) {
        dataSetPremierLeague = list
        notifyDataSetChanged()
    }

    class ViewHolderPremierLeague(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var matchNameLeague: TextView = itemView.TextView_TWO
        var dateMatchLeague: TextView = itemView.TextView_One
        var competitionName: TextView = itemView.TextView_THREE

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolderPremierLeague {
        return ViewHolderPremierLeague(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.item_list_view_holder, parent, false)
        )
    }

    override fun onBindViewHolder(holder: ViewHolderPremierLeague, position: Int) {
        val match = dataSetPremierLeague[position]
        holder.competitionName.text = match.title
        holder.dateMatchLeague.text = match.date
        holder.matchNameLeague.text = match.competition?.name.toString()
        // AQUI TENGO QUE USAR PICASSO PARA LAS FOTOS


    }

    override fun getItemCount(): Int {

        return dataSetPremierLeague.size
    }
}

