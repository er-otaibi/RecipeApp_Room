package com.example.recipeapp_room

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class AddRecipe : AppCompatActivity() {
    lateinit var etTitle: EditText
    lateinit var etAuthor: EditText
    lateinit var etIngredients: EditText
    lateinit var etInstructions: EditText
    lateinit var saveBtn: Button
    lateinit var viewBtn: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_recipe)

        supportActionBar?.hide()

        etTitle = findViewById(R.id.etTitle)
        etAuthor = findViewById(R.id.etAuthor)
        etIngredients = findViewById(R.id.etIngredients)
        etInstructions = findViewById(R.id.etInstructions)
        viewBtn = findViewById(R.id.viewBtn)
        saveBtn = findViewById(R.id.saveBtn)

        RecipeDatabase.getInstance(applicationContext)

        viewBtn.setOnClickListener {
            val intent = Intent(this, RecipeView::class.java)
            startActivity(intent)
        }

        saveBtn.setOnClickListener {
            var title = etTitle.text.toString()
            var author = etAuthor.text.toString()
            var ingredients = etIngredients.text.toString()
            var instructions = etInstructions.text.toString()
            if (title.isNotEmpty() && author.isNotEmpty() && ingredients.isNotEmpty() && instructions.isNotEmpty())
            {
                val recipeOBJ = Recipe(0,title,author,ingredients,instructions)
                CoroutineScope(Dispatchers.IO).launch {

                    RecipeDatabase.getInstance(applicationContext).RecipeDao().insertRecipe(recipeOBJ)

                }
                Toast.makeText(this, "New Recipe is added to your list!", Toast.LENGTH_LONG).show()
            } else {
                Toast.makeText(this, "Please Enter a Full Recipe", Toast.LENGTH_LONG).show()
            }
            clearText()

        }
    }

    private fun clearText() {
        etTitle.setText("")
        etAuthor.setText("")
        etIngredients.setText("")
        etInstructions.setText("")
    }

}