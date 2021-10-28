package com.example.recipeapp_room

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey



@Entity(tableName = "Recipe")
data class Recipe(
    @PrimaryKey(autoGenerate = true) @ColumnInfo(name = "id") val id : Int = 0,
    @ColumnInfo(name = "Title") val title: String,
    @ColumnInfo(name = "Author") val author: String,
    @ColumnInfo(name = "Ingredients") val ingredients: String,
    @ColumnInfo(name = "Instructions") val instructions: String,
)