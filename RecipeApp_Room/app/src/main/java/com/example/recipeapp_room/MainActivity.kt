package com.example.recipeapp_room

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportActionBar?.hide()

        var tvRecipe = findViewById<TextView>(R.id.tvRecipe)
        var createBtn = findViewById<Button>(R.id.create)

        createBtn.setOnClickListener {

            val intent = Intent(this, AddRecipe::class.java)
            startActivity(intent)
        }
    }
}