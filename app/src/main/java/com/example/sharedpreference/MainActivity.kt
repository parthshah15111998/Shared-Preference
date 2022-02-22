package com.example.sharedpreference

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Binder
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.sharedpreference.databinding.ActivityMainBinding
import java.util.prefs.Preferences

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    lateinit var sharedPreferences: SharedPreferences
    var isRemembered = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

         sharedPreferences=getSharedPreferences("SHAR_PRE",Context.MODE_PRIVATE)

         isRemembered = sharedPreferences.getBoolean("checked",false)

        if (isRemembered){
            val intet= Intent(this,MainActivity2::class.java)
            startActivity(intet)
            finish()
        }

        binding.btnSend1.setOnClickListener {
            val name:String=binding.etName.text.toString()
            val age:Int=binding.etAge.text.toString().toInt()
            val checked:Boolean=binding.checkBox.isChecked

            val editor:SharedPreferences.Editor=sharedPreferences.edit()
            editor.putString("name", name)
            editor.putInt("age",age)
            editor.putBoolean("checked",checked)
            editor.apply()

            Toast.makeText(this, "Information saved", Toast.LENGTH_SHORT).show()

            val intet= Intent(this,MainActivity2::class.java)
            startActivity(intet)
            finish()
        }


    }
}