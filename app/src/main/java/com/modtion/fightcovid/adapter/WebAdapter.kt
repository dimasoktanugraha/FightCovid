package com.modtion.fightcovid.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
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
        fun bindItem(items: WebModel, listener: (WebModel) -> Unit) {

            itemView.setOnClickListener {
                listener(items)
            }
        }
    }


}