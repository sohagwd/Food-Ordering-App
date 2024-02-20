package com.example.adminfoodorderingapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.adminfoodorderingapp.Adapter.AddItemAdapter
import com.example.adminfoodorderingapp.databinding.ActivityAllItemBinding

class AllItemActivity : AppCompatActivity() {
    private lateinit var binding:ActivityAllItemBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityAllItemBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.backBtn.setOnClickListener {
            finish()
        }

        val menuFoodName = listOf("Burger","Sandwich","Momo","Chicken Fry","Donuts")
        val menuItemPrice = listOf("5$","3$","7$","10$","4$")
        val menuImage = listOf(
            R.drawable.menu1,
            R.drawable.menu2,
            R.drawable.menu3,
            R.drawable.menu4,
            R.drawable.menu5
        )

        val adapter = AddItemAdapter(ArrayList(menuFoodName), ArrayList(menuItemPrice),
            ArrayList(menuImage)
        )

        binding.menuRecyclerView.layoutManager = LinearLayoutManager(this)
        binding.menuRecyclerView.adapter = adapter
    }
}