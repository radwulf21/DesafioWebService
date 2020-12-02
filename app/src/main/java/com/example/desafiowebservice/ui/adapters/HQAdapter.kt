package com.example.desafiowebservice.ui.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.desafiowebservice.R
import com.example.desafiowebservice.domain.HQ

class HQAdapter() : RecyclerView.Adapter<HQAdapter.HQAdapterViewHolder>() {
    var listHQ = arrayListOf<HQ>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HQAdapterViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.item_hq, parent, false)
        return HQAdapterViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: HQAdapterViewHolder, position: Int) {
        val hq = listHQ[position]
        holder.ivHQ.setImageResource(hq.imgHQ)
        holder.tvNumHQ.text = hq.numHQ
    }

    override fun getItemCount() = listHQ.size

    fun addListHQ(list: ArrayList<HQ>) {
        listHQ.addAll(list)
        notifyDataSetChanged()
    }

    class HQAdapterViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        val ivHQ: ImageView = itemView.findViewById(R.id.ivHQ)
        val tvNumHQ: TextView = itemView.findViewById(R.id.tvNumHQ)
    }
}