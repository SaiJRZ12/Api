package com.simon.api

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.simon.valorantapi.R

class Adapter (var gamesList: List<RAWGItemResponse> = emptyList()) : RecyclerView.Adapter<ViewHolder>() {

    fun updateList(list: List<RAWGItemResponse>){
        gamesList = list
        notifyDataSetChanged()
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_games, parent, false))
    }

    override fun getItemCount() = gamesList.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(gamesList[position])
    }

}