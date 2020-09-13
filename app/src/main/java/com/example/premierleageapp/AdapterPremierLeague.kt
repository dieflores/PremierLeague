package com.example.premierleageapp

import android.app.Dialog
import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import android.widget.VideoView
import androidx.recyclerview.widget.RecyclerView
import com.example.premierleageapp.Api.PremierLeague
import com.example.premierleageapp.Api.Videos
import com.google.gson.Gson
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.item_list_view_holder.view.*

class AdapterPremierLeague(var dataSetPremierLeague: List<PremierLeague>) :
    RecyclerView.Adapter<AdapterPremierLeague.ViewHolderPremierLeague>(), View.OnClickListener {

    fun updateData(list: List<PremierLeague>) {
        dataSetPremierLeague = list
        notifyDataSetChanged()
    }

    class ViewHolderPremierLeague(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var matchNameLeague: TextView = itemView.TextView_TWO
        var dateMatchLeague: TextView = itemView.TextView_One
        var competitionName: TextView = itemView.TextView_THREE
        var imageMatch: ImageButton = itemView.image_one
        var clickImage: TextView = itemView.clickmeImage
       // var embedMatchLive: VideoView = itemView.videoView


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
        holder.clickImage.setOnClickListener{

            val premierDialog = Dialog(holder.itemView.context)

            premierDialog.setContentView(R.layout.fragment_video)

        }


    }

    override fun getItemCount(): Int {

        return dataSetPremierLeague.size
    }

    override fun onClick(v: View?) {

    }

}

