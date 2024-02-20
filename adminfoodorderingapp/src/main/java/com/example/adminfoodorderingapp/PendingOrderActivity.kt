package com.example.adminfoodorderingapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.adminfoodorderingapp.Adapter.DeliveryAdapter
import com.example.adminfoodorderingapp.Adapter.PendingOrderAdapter
import com.example.adminfoodorderingapp.databinding.ActivityPendingOrderBinding

class PendingOrderActivity : AppCompatActivity() {
    private lateinit var binding:ActivityPendingOrderBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityPendingOrderBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.backBtn.setOnClickListener {
            finish()
        }

        val orderCustomerName = arrayListOf(
            "Md.Sohag",
            "Niraviman Singha",
            "Md.Zahid Khan",
        )

        val orderQuantity = arrayListOf(
            "8",
            "4",
            "6"
        )

        val orderFoodImage = arrayListOf(
            R.drawable.menu1,
            R.drawable.menu2,
            R.drawable.menu3
        )

        val adapter = PendingOrderAdapter(orderCustomerName,orderQuantity,orderFoodImage, this )
        binding.pendingOrderRecyclerView.layoutManager = LinearLayoutManager(this)
        binding.pendingOrderRecyclerView.adapter = adapter
    }

}