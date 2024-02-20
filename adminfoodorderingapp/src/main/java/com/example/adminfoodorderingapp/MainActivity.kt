package com.example.adminfoodorderingapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.adminfoodorderingapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityMainBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.pendingOrder.setOnClickListener {
            val intent = Intent(this@MainActivity, PendingOrderActivity::class.java)
            startActivity(intent)
        }

        binding.addMenu.setOnClickListener {
            val intent = Intent(this@MainActivity, AddItemActivity::class.java)
            startActivity(intent)
        }

        binding.allItemMenu.setOnClickListener {
            val intent = Intent(this@MainActivity, AllItemActivity::class.java)
            startActivity(intent)
        }

        binding.outputDelivery.setOnClickListener {
            val intent = Intent(this@MainActivity, OutForDeliveryActivity::class.java)
            startActivity(intent)
        }

        binding.profile.setOnClickListener {
            val intent = Intent(this@MainActivity, AdminProfileActivity::class.java)
            startActivity(intent)
        }

        binding.createUser.setOnClickListener {
            val intent = Intent(this@MainActivity, CreateUserActivity::class.java)
            startActivity(intent)
        }


    }
}