package com.example.adminfoodorderingapp.Adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.adminfoodorderingapp.databinding.AllMenuItemBinding

class AddItemAdapter(
    private val MenuItemName: ArrayList<String>,
    private val MenuItemPrice: ArrayList<String>,
    private val MenuItemImage: ArrayList<Int>
) : RecyclerView.Adapter<AddItemAdapter.AllItemViewHolder>() {

    private val itemQuantities = IntArray(MenuItemName.size) { 1 }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AllItemViewHolder {
        val binding = AllMenuItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return AllItemViewHolder(binding)
    }


    override fun onBindViewHolder(holder: AllItemViewHolder, position: Int) {
        holder.bind(position)
    }

    override fun getItemCount(): Int = MenuItemName.size

    inner class AllItemViewHolder(private val binding: AllMenuItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(position: Int) {
            binding.apply {
                val quanity = itemQuantities[position]
                foodNameTV.text = MenuItemName[position]
                priceTV.text = MenuItemPrice[position]
                foodImageView.setImageResource(MenuItemImage[position])

                quantityTV.text = quanity.toString()

                minusButton.setOnClickListener {
                    decreaseQuantity(position)
                }

                plusButton.setOnClickListener {
                    increaseQuantity(position)
                }

                deleteBtn.setOnClickListener {
                    deleteQuantity(position)
                }
            }
        }


        private fun increaseQuantity(position: Int) {
            if (itemQuantities[position] < 10) {
                itemQuantities[position]++
                binding.quantityTV.text = itemQuantities[position].toString()

            }

        }

        private fun decreaseQuantity(position: Int) {
            if (itemQuantities[position] > 1) {
                itemQuantities[position]--
                binding.quantityTV.text = itemQuantities[position].toString()

            }

        }

        private fun deleteQuantity(position: Int) {
            MenuItemName.removeAt(position)
            MenuItemPrice.removeAt(position)
            MenuItemImage.removeAt(position)

            notifyItemRemoved(position)
            notifyItemRangeChanged(position, MenuItemName.size)

        }

    }
}