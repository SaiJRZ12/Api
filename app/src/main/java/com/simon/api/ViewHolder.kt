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
        binding.tvReleased.text = ItemResponse.released
        binding.tvPlaytime.text = ItemResponse.playtime.toString()
        binding.tvRating.text = ItemResponse.rating.toString()
        val platformNames = StringBuilder()

        for (plataforma in ItemResponse.platforms) {
           
            val plataformaItem = plataforma.platform

            platformNames.append(plataformaItem.namePl).append(", ")
        }

        val result = if (platformNames.isNotEmpty()) {
            platformNames.substring(0, platformNames.length - 2)
        } else {
            "No hay plataformas disponibles"
        }


        binding.tvPlatforms.text = result
    }

}
