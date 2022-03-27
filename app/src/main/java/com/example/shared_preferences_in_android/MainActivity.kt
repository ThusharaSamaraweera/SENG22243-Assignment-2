package com.example.shared_preferences_in_android

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import com.example.shared_preferences_in_android.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val sharedPref = getSharedPreferences("loginPref", Context.MODE_PRIVATE)
        val editor = sharedPref.edit()

        binding.btnLogin.setOnClickListener{
            val userName = binding.etUserName.text
            val password = binding.etPassword.text
            val isRememberMeOn = binding.switchRememberMe.isChecked

            editor.apply {
                putString("userName", userName.toString())
                putBoolean("isRememberMeOn", isRememberMeOn)
                apply()
            }
        }

        binding.btnLoad.setOnClickListener {
            val userName = sharedPref.getString("userName", "")
            val isRememberMeOn = sharedPref.getBoolean("isRememberMeOn", false)

            binding.tvUserNameOutput.text = userName
            binding.tvRememberMeOutput.text = isRememberMeOn.toString()
        }


    }

}