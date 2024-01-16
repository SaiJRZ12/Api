package com.simon.api

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.simon.valorantapi.databinding.ItemGamesBinding
import com.squareup.picasso.Picasso

class ViewHolder(view: View): RecyclerView.ViewHolder(view) {

    private val binding = ItemGamesBinding.bind(view)
    fun bind(ItemResponse: RAWGItemResponse) {
        binding.tvGameName.text = ItemResponse.name
        Picasso.get().load(ItemResponse.img).into(binding.ivGames)
    }
}