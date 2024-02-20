package com.example.adminfoodorderingapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.adminfoodorderingapp.Adapter.DeliveryAdapter
import com.example.adminfoodorderingapp.databinding.ActivityOutForDeliveryBinding

class OutForDeliveryActivity : AppCompatActivity() {
    private lateinit var binding:ActivityOutForDeliveryBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityOutForDeliveryBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.backBtn.setOnClickListener {
            finish()
        }

        val customerName = arrayListOf(
            "Md.Sohag",
            "Niraviman Singha",
            "Md.Zahid Khan",
        )

        val moneyStatus = arrayListOf(
            "Received",
            "notReceived",
            "Pending"
        )

        val adapter = DeliveryAdapter(customerName,moneyStatus)
        binding.deliveryRecyclerView.layoutManager = LinearLayoutManager(this)
        binding.deliveryRecyclerView.adapter = adapter
    }
}