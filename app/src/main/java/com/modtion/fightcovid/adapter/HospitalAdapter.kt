package com.modtion.fightcovid.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.modtion.fightcovid.R
import com.modtion.fightcovid.model.Hospital
import com.modtion.fightcovid.model.WebModel

class HospitalAdapter(private val items: List<Hospital>, private val listener: (Hospital) -> Unit) : RecyclerView.Adapter<HospitalAdapter.HosViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HosViewHolder =
        HosViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_hospital, parent, false))

    override fun getItemCount(): Int = items.size

    override fun onBindViewHolder(holder: HosViewHolder, position: Int) {
        holder.bindItem(items[position], listener)
    }

    class HosViewHolder (itemView: View) : RecyclerView.ViewHolder(itemView){
        val item_hos_name: TextView = itemView.findViewById(R.id.item_hos_name)
        val item_hos_address: TextView = itemView.findViewById(R.id.item_hos_address)
        val item_hos_phone: TextView = itemView.findViewById(R.id.item_hos_phone)

        fun bindItem(items: Hospital, listener: (Hospital) -> Unit) {
            item_hos_name.text = items.name
            item_hos_address.text = items.address
            item_hos_address.text = items.telp
            itemView.setOnClickListener {
                listener(items)
            }
        }
    }


}