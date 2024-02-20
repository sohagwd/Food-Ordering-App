package com.example.adminfoodorderingapp.Adapter

import android.content.res.ColorStateList
import android.graphics.Color
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.adminfoodorderingapp.databinding.DeliveryItemsBinding

class DeliveryAdapter(private val customerNames:ArrayList<String>,private val moneyStatus:ArrayList<String>):RecyclerView.Adapter<DeliveryAdapter.DeliveryViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DeliveryViewHolder {
       val binding = DeliveryItemsBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return DeliveryViewHolder(binding)
    }

    override fun onBindViewHolder(holder: DeliveryViewHolder, position: Int) {
      holder.bind(position)
    }

    override fun getItemCount(): Int = customerNames.size

    inner class DeliveryViewHolder(private val binding:DeliveryItemsBinding):RecyclerView.ViewHolder(binding.root) {
        fun bind(position: Int) {
           binding.apply {
               customerNameTV.text = customerNames[position]
               statusMoney.text = moneyStatus[position]

               val  colorMap = mapOf(
                   "Received" to Color.GREEN, "notReceived" to Color.RED, "Pending" to Color.GRAY
               )

               statusMoney.setTextColor(colorMap[moneyStatus[position]]?:Color.BLACK)
               statusColor.backgroundTintList = ColorStateList.valueOf(colorMap[moneyStatus[position]]?:Color.BLACK)
           }
        }

    }
}