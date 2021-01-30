package com.example.desafiowebservice.ui.activities.home

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.desafiowebservice.R
import com.example.desafiowebservice.domain.Result

class HQAdapter(var listener: OnClickHQListener, var context: HomeActivity) : RecyclerView.Adapter<HQAdapter.HQAdapterViewHolder>() {
    var listHQ = arrayListOf<Result>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HQAdapterViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.item_hq, parent, false)
        return HQAdapterViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: HQAdapterViewHolder, position: Int) {
        val hq = listHQ[position]

        Glide.with(holder.itemView).load("${hq.thumbnail?.path}.${hq.thumbnail?.extension}").into(holder.ivHQ)
        holder.tvNumHQ.text = hq.id.toString()
    }

    override fun getItemCount() = listHQ.size

    fun addListHQ(list: ArrayList<Result>) {
        listHQ.addAll(list)
        notifyDataSetChanged()
    }

    inner class HQAdapterViewHolder(itemView: View): RecyclerView.ViewHolder(itemView), View.OnClickListener {
        val ivHQ: ImageView = itemView.findViewById(R.id.ivHQ)
        val tvNumHQ: TextView = itemView.findViewById(R.id.tvNumHQ)

        init {
            itemView.setOnClickListener(this)
        }

        override fun onClick(v: View?) {
            val position = adapterPosition
            if (position != RecyclerView.NO_POSITION) {
                listener.onClickHQ(position)
            }
        }
    }

    interface OnClickHQListener {
        fun onClickHQ(position: Int)
    }
}