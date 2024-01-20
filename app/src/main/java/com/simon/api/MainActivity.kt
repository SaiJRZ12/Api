package com.simon.api

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.appcompat.widget.SearchView
import androidx.core.view.isVisible
import androidx.recyclerview.widget.LinearLayoutManager
import com.simon.valorantapi.databinding.ActivityMainBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var retrofit: Retrofit
    private lateinit var adapter: Adapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        retrofit = getRetrofit()
        initUI()
    }

    private fun initUI() {
        binding.searchView.setOnQueryTextListener(object: SearchView.OnQueryTextListener
        {
            override fun onQueryTextSubmit(query: String?): Boolean {
                searchByName(query.orEmpty())
                return false
            }

            override fun onQueryTextChange(newText: String?) = false

        })

        adapter = Adapter()
        binding.rvList.setHasFixedSize(true)
        binding.rvList.layoutManager = LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL, false)
        binding.rvList.adapter = adapter
    }



    private fun searchByName(query: String) {
        binding.progressBar.isVisible = true
        CoroutineScope(Dispatchers.IO).launch {
            val myResponse: Response<RAWGDataResponse> =
                retrofit.create(ApiService::class.java).getGames(query)
            if (myResponse.isSuccessful) {
                Log.i("Consulta", "Funcionaaaaaaaaaaaaa :)")
                val response: RAWGDataResponse? = myResponse.body()
                if (response != null) {
                    Log.i("Cuerpo de la consulta", response.toString())
                    runOnUiThread {
                        adapter.updateList(response.results)
                        binding.progressBar.isVisible = false
                    }
                }

            } else {
                Log.i("Consulta", "No funciona :(")
            }
        }
    }

    private fun getRetrofit(): Retrofit {
        return Retrofit
            .Builder()
            .baseUrl("https://api.rawg.io/api/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

}

