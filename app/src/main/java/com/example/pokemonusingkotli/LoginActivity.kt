package com.example.pokemonusingkotli

import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.pokemonusingkotli.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity() {

    lateinit var binding: ActivityLoginBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        loadData()
        if(loadData()==true){
            var intent=Intent(this,MainActivity::class.java)
            startActivity(intent)
            finish()
            //Toast.makeText(this,"Data Loaded",Toast.LENGTH_SHORT).show()
        }
        binding.loginBtn.setOnClickListener{
            saveData()
            var intent=Intent(this,MainActivity::class.java)
            startActivity(intent)
            finish()
        }

        binding.tvSignup.setOnClickListener{
            var intent=Intent(this,SignupActivity::class.java)
            startActivity(intent)
            finish()
        }

    }

    fun saveData() {
        var preferences: SharedPreferences = getSharedPreferences("sharedPref", MODE_PRIVATE)
        var editor = preferences.edit()

        editor.apply() {
            putBoolean("key",true)
        }.apply()

        //Toast.makeText(this,"Data Saved",Toast.LENGTH_SHORT).show()
    }

    fun loadData():Boolean{
        var preferences:SharedPreferences=getSharedPreferences("sharedPref", MODE_PRIVATE)
        var mykey=preferences.getBoolean("key",false)
        return mykey
    }
}