package com.homebridge.app_sem7_challenge_friends.activities

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.homebridge.app_sem7_challenge_friends.R

class MainActivity : AppCompatActivity() {
    private lateinit var peopleBtn: Button
    private lateinit var favoriteBtn: Button
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        peopleBtn = findViewById(R.id.btPeople)
        favoriteBtn = findViewById(R.id.btFavorite)

        peopleBtn.setOnClickListener {
            val intent = Intent(this, PeopleActivity::class.java)
            startActivity(intent)
        }

        favoriteBtn.setOnClickListener {
            val intent = Intent(this, FavoriteActivity::class.java)
            startActivity(intent)
        }
    }
}