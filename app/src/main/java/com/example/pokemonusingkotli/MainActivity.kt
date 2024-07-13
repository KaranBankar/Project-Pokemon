package com.example.pokemonusingkotli

import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.SortedList.Callback
import com.example.pokemonusingkotli.Adapter.PokemonAdapter
import com.example.pokemonusingkotli.Api.RetrofitInsatnce
import com.example.pokemonusingkotli.Model.data
import com.example.pokemonusingkotli.databinding.ActivityMainBinding
import com.example.pokemonusingkotli.databinding.ItemLayoutBinding
import com.example.pokemonusingkotli.Model.Result
import retrofit2.Call
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding
    lateinit var adapter: PokemonAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding=ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // Set LayoutManager for RecyclerView
        binding.recycler.layoutManager = LinearLayoutManager(this)

        RetrofitInsatnce.api.pokemonName("151").enqueue(object : retrofit2.Callback<data?> {
            override fun onResponse(call: Call<data?>, response: Response<data?>) {


                if(response.isSuccessful){
                    adapter=PokemonAdapter(response.body()!!.results as ArrayList<Result>)
                    binding.recycler.adapter=adapter
                    Toast.makeText(baseContext,"Data Load Successfully",Toast.LENGTH_LONG).show()
                }
            }

            override fun onFailure(call: Call<data?>, t: Throwable) {
                Toast.makeText(baseContext, "Data Load Failed: ${t.message}", Toast.LENGTH_LONG).show()
            }
        })
    }
}