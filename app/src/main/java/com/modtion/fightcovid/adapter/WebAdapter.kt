package com.modtion.fightcovid.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.modtion.fightcovid.R
import com.modtion.fightcovid.model.WebModel

class WebAdapter(private val items: List<WebModel>, private val listener: (WebModel) -> Unit) : RecyclerView.Adapter<WebAdapter.WebViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WebViewHolder =
        WebViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_web, parent, false))

    override fun getItemCount(): Int = items.size

    override fun onBindViewHolder(holder: WebViewHolder, position: Int) {
        holder.bindItem(items[position], listener)
    }

    class WebViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        val item_tv_city: TextView = itemView.findViewById(R.id.item_tv_city)
        val item_tv_web: TextView = itemView.findViewById(R.id.item_tv_web)

        fun bindItem(items: WebModel, listener: (WebModel) -> Unit) {
            item_tv_city.text = items.city
            item_tv_web.text = items.website
            itemView.setOnClickListener {
                listener(items)
            }
        }
    }


}