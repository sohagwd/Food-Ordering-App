package com.example.foodorderingapp.Adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View.OnClickListener
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.foodorderingapp.DetailsActivity
import com.example.foodorderingapp.databinding.MenuItemBinding

class MenuAdapter(private val menuItemName:MutableList<String>,private val menuItemPrice:MutableList<String>,private val MenuImage:MutableList<Int>, private val requireContext:Context):RecyclerView.Adapter<MenuAdapter.MenuViewHolder>() {

private val itemClickListener:OnClickListener ?= null
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MenuViewHolder {
       val binding = MenuItemBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return MenuViewHolder(binding)
    }



    override fun onBindViewHolder(holder: MenuViewHolder, position: Int) {
        holder.bind(position)
    }

    override fun getItemCount(): Int = menuItemName.size

    inner class MenuViewHolder(private val binding:MenuItemBinding):RecyclerView.ViewHolder(binding.root) {
        init {
            binding.root.setOnClickListener {
                val position = adapterPosition
                if (position != RecyclerView.NO_POSITION){
                    itemClickListener?.onItemClick(position)
                }

                val intent = Intent(requireContext, DetailsActivity::class.java)
                intent.putExtra("MenuItemName",menuItemName.get(position))
                intent.putExtra("MenuItemImage",MenuImage.get(position))

                requireContext.startActivity(intent)
            }
        }
        fun bind(position: Int) {
            binding.apply {
                menuFoodName.text = menuItemName[position]
                menuPrice.text = menuItemPrice[position]
                menuImage.setImageResource(MenuImage[position])


            }
        }

    }
    interface OnClickListener{
        fun onItemClick(position: Int) {

        }
    }
}



