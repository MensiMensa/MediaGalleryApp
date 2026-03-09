package com.example.myapplication2

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import com.example.myapplication2.databinding.ActivityFavoritesBinding

class FavoritesActivity : AppCompatActivity() {
    private lateinit var binding: ActivityFavoritesBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFavoritesBinding.inflate(layoutInflater)
        setContentView(binding.root)

        title = "Favorites"
        
        // In a real app, you'd fetch favorites from a database.
        val favoriteItems = mutableListOf<MediaItem>() 
        
        binding.favoritesRecyclerView.layoutManager = GridLayoutManager(this, 3)
        binding.favoritesRecyclerView.adapter = MediaAdapter(favoriteItems) { item ->
            // Handle click
        }
    }
}