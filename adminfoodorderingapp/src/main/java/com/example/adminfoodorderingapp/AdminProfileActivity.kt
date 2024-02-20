package com.example.adminfoodorderingapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.adminfoodorderingapp.databinding.ActivityAdminProfileBinding

class AdminProfileActivity : AppCompatActivity() {
    private lateinit var binding:ActivityAdminProfileBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityAdminProfileBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.backBtn.setOnClickListener {
            finish()
        }

        binding.nameET.isEnabled = false
        binding.addressET.isEnabled = false
        binding.emailET.isEnabled = false
        binding.phoneET.isEnabled = false
        binding.passwordET.isEnabled = false

        var isEnable = false
        binding.editBtn.setOnClickListener {
            isEnable = !isEnable

            binding.nameET.isEnabled = isEnable
            binding.addressET.isEnabled = isEnable
            binding.emailET.isEnabled = isEnable
            binding.phoneET.isEnabled = isEnable
            binding.passwordET.isEnabled = isEnable

            if (isEnable){
                binding.nameET.requestFocus()
            }
        }
    }
}