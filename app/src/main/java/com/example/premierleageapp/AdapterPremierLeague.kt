package com.example.premierleageapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.premierleageapp.Api.PremierLeague
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.item_list_view_holder.view.*

class AdapterPremierLeague(
    var dataSetPremierLeague: List<PremierLeague>,
    val mpasarElDato: PasarElDato
) :
    RecyclerView.Adapter<AdapterPremierLeague.ViewHolderPremierLeague>() {

    fun updateData(list: List<PremierLeague>) {
        dataSetPremierLeague = list
        notifyDataSetChanged()
    }


    inner class ViewHolderPremierLeague(itemView: View) : RecyclerView.ViewHolder(itemView),
        View.OnClickListener {
        var matchNameLeague: TextView = itemView.LeagueName
        var dateMatchLeague: TextView = itemView.dateMatch
        var competitionName: TextView = itemView.versusName
        var imageMatch: ImageButton = itemView.image_one
        var clickImage: TextView = itemView.avisoDeClick //Solo texto

        // Competition
        var nameCompetition: TextView = itemView.nameCompetition
        var idCompetition: TextView = itemView.idCompetition
        var urlCompetition: TextView = itemView.urlCompetition
        var imageMatchOne = itemView.setOnClickListener(this)

        override fun onClick(v: View?) {
            dataSetPremierLeague[adapterPosition].embed?.let { mpasarElDato.pasarElDato(it) }

        }


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
        holder.matchNameLeague.text = match.competition!!.name.toString()
        // AQUI TENGO QUE USAR PICASSO PARA LAS FOTOS
        Picasso.get().load(match.thumbnail).into(holder.imageMatch)

        // Layout pequeño con info
        holder.nameCompetition.text = match.competition.name.toString()
        holder.idCompetition.text = match.competition.id.toString()
        holder.urlCompetition.text = match.competition.url.toString()


    }

    override fun getItemCount(): Int {

        return dataSetPremierLeague.size
    }

    interface PasarElDato {
        fun pasarElDato(embed: String)
    }

}



