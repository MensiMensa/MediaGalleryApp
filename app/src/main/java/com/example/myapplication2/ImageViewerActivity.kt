package com.example.myapplication2

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.example.myapplication2.databinding.ActivityImageViewerBinding

class ImageViewerActivity : AppCompatActivity() {
    private lateinit var binding: ActivityImageViewerBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityImageViewerBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val mediaItem = intent.getParcelableExtra<MediaItem>("MEDIA_ITEM")
        mediaItem?.let {
            Glide.with(this)
                .load(it.uri)
                .into(binding.imageView)
            
            updateFavoriteIcon(it.isFavorite)
            binding.favoriteButton.setOnClickListener {
                mediaItem.isFavorite = !mediaItem.isFavorite
                updateFavoriteIcon(mediaItem.isFavorite)
                // In a real app, update this in a database or shared preferences
            }
        }
    }

    private fun updateFavoriteIcon(isFavorite: Boolean) {
        val iconRes = if (isFavorite) {
            android.R.drawable.btn_star_big_on
        } else {
            android.R.drawable.btn_star_big_off
        }
        binding.favoriteButton.setImageResource(iconRes)
    }
}