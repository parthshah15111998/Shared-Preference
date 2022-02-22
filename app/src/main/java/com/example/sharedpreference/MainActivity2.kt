package com.example.sharedpreference

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.sharedpreference.databinding.ActivityMain2Binding

class MainActivity2 : AppCompatActivity() {
    private lateinit var binding: ActivityMain2Binding
    lateinit var  perferences:SharedPreferences
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMain2Binding.inflate(layoutInflater)
        setContentView(binding.root)


        perferences=getSharedPreferences("SHAR_PRE", Context.MODE_PRIVATE)

        val name=perferences.getString("name","")
        binding.tvName.text=name

        val age=perferences.getInt("age",0)
        binding.tvAge.text=""+age

        binding.btnSend2.setOnClickListener {
            val editor: SharedPreferences.Editor = perferences.edit()
            editor.clear()
            editor.apply()

            val intent= Intent(this,MainActivity::class.java)
            startActivity(intent)
            finish()
        }

    }
}