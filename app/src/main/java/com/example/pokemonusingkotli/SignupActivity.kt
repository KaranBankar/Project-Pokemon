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
import com.example.pokemonusingkotli.databinding.ActivitySignupBinding

class SignupActivity : AppCompatActivity() {

    lateinit var binding: ActivitySignupBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding=ActivitySignupBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        binding.signupBtn.setOnClickListener{
            var username=binding.usernameSign.text.toString()
            var email=binding.emailSign.text.toString()
            var password=binding.passwordSign.text.toString()

            var preferences:SharedPreferences=getSharedPreferences("sharedPref", MODE_PRIVATE)
            var editor=preferences.edit()

            editor.apply(){
                putString("username",username)
                putString("password",password)
                putString("email",email)
            }.apply()

            //Toast.makeText(this,"Data Saved",Toast.LENGTH_SHORT).show()
            var intet=Intent(this,LoginActivity::class.java)
            startActivity(intet)
            finish()
        }

        binding.tvLogin.setOnClickListener{
            var intent=Intent(this,LoginActivity::class.java)
            startActivity(intent)
            finish()
        }

        binding.backImg.setOnClickListener{
            var intent=Intent(this,LoginActivity::class.java)
            startActivity(intent)
            finish()
        }


    }
}