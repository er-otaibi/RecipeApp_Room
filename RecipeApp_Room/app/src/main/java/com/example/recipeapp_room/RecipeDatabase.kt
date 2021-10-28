package com.example.recipeapp_room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase


@Database(entities = [Recipe::class],version = 1,exportSchema = false)
abstract class RecipeDatabase: RoomDatabase() {

    companion object{
        var instance:RecipeDatabase?=null;
        fun getInstance(ctx: Context):RecipeDatabase
        {
            if(instance!=null)
            {
                return  instance as RecipeDatabase;
            }
            instance= Room.databaseBuilder(ctx,RecipeDatabase::class.java,"RecipesDB").run { allowMainThreadQueries() }.build();
            return instance as RecipeDatabase;
        }
    }
    abstract fun RecipeDao():RecipeDao;
}