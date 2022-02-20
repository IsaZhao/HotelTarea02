package com.tarea02.adapter

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.tarea02.databinding.HotelFilaBinding

class HotelAdapter : RecyclerView.Adapter<HotelAdapter.HotelViewHolder>(){

    inner class HotelViewHolder(private val itemBinding: HotelFilaBinding)
        : RecyclerView.ViewHolder(itemBinding.root){

        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HotelViewHolder {
        TODO("Not yet implemented")
    }

    override fun onBindViewHolder(holder: HotelViewHolder, position: Int) {
        TODO("Not yet implemented")
    }

    override fun getItemCount(): Int {
        TODO("Not yet implemented")
    }
}