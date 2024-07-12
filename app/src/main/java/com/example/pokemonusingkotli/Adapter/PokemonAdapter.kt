package com.example.pokemonusingkotli.Adapter

import android.provider.ContactsContract.Data
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.pokemonusingkotli.Model.Result
import com.example.pokemonusingkotli.Model.data
import com.example.pokemonusingkotli.databinding.ItemLayoutBinding
import java.util.zip.Inflater

class PokemonAdapter(private val items:List<Result>): RecyclerView.Adapter<PokemonAdapter.Poke>(){




    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Poke {
        val inflater=LayoutInflater.from(parent.context)
        val binding=ItemLayoutBinding.inflate(inflater,parent,false)
        return Poke(binding)
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: Poke, position: Int) {
        val currentitem=items[position]
        holder.bind(currentitem)
    }

    inner  class Poke (private val binding: ItemLayoutBinding):RecyclerView.ViewHolder(binding.root){

        fun bind(item:Result){

            binding.pokeName.text=item.name.toString()
            binding.pokeUrl.text=item.url.toString()

        }

    }
}