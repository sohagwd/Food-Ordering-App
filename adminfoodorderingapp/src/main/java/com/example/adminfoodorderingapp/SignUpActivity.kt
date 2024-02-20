package com.example.adminfoodorderingapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ArrayAdapter
import android.widget.Toast
import com.example.adminfoodorderingapp.Model.UserModel
import com.example.adminfoodorderingapp.databinding.ActivitySignUpBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.auth.ktx.auth
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase

class SignUpActivity : AppCompatActivity() {

    private lateinit var email:String
    private lateinit var password:String
    private lateinit var userName:String
    private lateinit var nameOfRestaurant:String
    private lateinit var database:DatabaseReference
    private lateinit var auth:FirebaseAuth

    private lateinit var binding:ActivitySignUpBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivitySignUpBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        // initialize Firebase Auth
        auth = Firebase.auth

        // initialize Firebase Database
        database = Firebase.database.reference


        binding.createBtn.setOnClickListener {
            // get text from editText
            userName = binding.nameET.text.toString().trim()
            nameOfRestaurant = binding.restaurantNameET.text.toString().trim()
            email = binding.emailET.text.toString().trim()
            password = binding.passwordET.text.toString().trim()

            if (userName.isBlank() || nameOfRestaurant.isBlank() || email.isBlank() || password.isBlank()){
                Toast.makeText(this,"Please fill all details",Toast.LENGTH_SHORT).show()
            }
            else{
                createAccount(email,password)

            }

        }

        binding.alreadyHaveAccountbtn.setOnClickListener {
            val intent = Intent(this@SignUpActivity,LoginActivity::class.java)
            startActivity(intent)
        }

        val locationList = arrayOf("Dhanmondi","Mirpur","Farmgate","Shyamoli","Mohammadpur")
        val adapter = ArrayAdapter(this,android.R.layout.simple_list_item_1,locationList)
        val autoCompleteTextView = binding.listOfLocation
        autoCompleteTextView.setAdapter(adapter)
    }

    private fun createAccount(email: String, password: String) {
        auth.createUserWithEmailAndPassword(email,password).addOnCompleteListener {
            if (it.isSuccessful){
                Toast.makeText(this,"Account Created Successfully",Toast.LENGTH_SHORT).show()
                saveUserData()
                val intent = Intent(this@SignUpActivity,LoginActivity::class.java)
                startActivity(intent)
                finish()
            }
            else{
                Toast.makeText(this,"Account Creation Failed!",Toast.LENGTH_SHORT).show()
                Log.d("Account","createAccount:Failure",it.exception)
            }
        }
    }

    // Save data into database
    private fun saveUserData() {
        // get text from editText
        userName = binding.nameET.text.toString().trim()
        nameOfRestaurant = binding.restaurantNameET.text.toString().trim()
        email = binding.emailET.text.toString().trim()
        password = binding.passwordET.text.toString().trim()

        val user = UserModel(userName, nameOfRestaurant, email, password)
        val userId:String = FirebaseAuth.getInstance().currentUser!!.uid

        // Save user data into Firebase Database
        database.child("user").child(userId).setValue(user)


    }
}