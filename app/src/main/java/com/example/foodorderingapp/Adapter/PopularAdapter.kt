package com.example.foodorderingapp.Adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.foodorderingapp.DetailsActivity
import com.example.foodorderingapp.databinding.PopularItemBinding

class PopularAdapter(private val items:List<String>,private val price:List<String>,private val image:List<Int>,private val requireContext: Context) : RecyclerView.Adapter<PopularAdapter.PopularViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PopularViewHolder {
      return PopularViewHolder(PopularItemBinding.inflate(LayoutInflater.from(parent.context),parent,false))
    }



    override fun onBindViewHolder(holder: PopularViewHolder, position: Int) {
       val item = items[position]
        val price = price[position]
        val images = image[position]
        
        holder.bind(item,price,images)

        holder.itemView.setOnClickListener {
            val intent = Intent(requireContext, DetailsActivity::class.java)
            intent.putExtra("MenuItemName",item)
            intent.putExtra("MenuItemImage",images)

            requireContext.startActivity(intent)
        }
    }

    override fun getItemCount(): Int {
       return items.size
    }

    class PopularViewHolder(private val binding:PopularItemBinding):RecyclerView.ViewHolder(binding.root) {
        val imageView = binding.imageView
        fun bind(item: String,price: String ,images: Int) {
            binding.foodNamePopular.text = item
            binding.pricePopular.text = price
            imageView.setImageResource(images)

        }

    }
}