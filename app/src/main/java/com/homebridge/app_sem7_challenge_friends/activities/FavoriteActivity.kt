package com.homebridge.app_sem7_challenge_friends.activities

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.homebridge.app_sem7_challenge_friends.R
import com.homebridge.app_sem7_challenge_friends.adapters.PersonAdapter
import com.homebridge.app_sem7_challenge_friends.db.AppDatabase
import com.homebridge.app_sem7_challenge_friends.models.Person

class FavoriteActivity : AppCompatActivity(), PersonAdapter.OnItemClickListener {
    private lateinit var rvFavorite : RecyclerView

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_favorite)

        setSupportActionBar(findViewById(R.id.toolbar2))

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setDisplayShowHomeEnabled(true)
        rvFavorite = findViewById(R.id.rvFavorite)
    }

    override fun onResume() {
        super .onResume()

        loadPeople { people ->
            rvFavorite.adapter = PersonAdapter(people, this)
            rvFavorite.layoutManager = LinearLayoutManager(this@FavoriteActivity)
        }
    }

    private fun loadPeople(onComplete: (List<Person>)-> Unit) {
        val dao = AppDatabase.getInstance(this).getDao()

        onComplete(dao.getAll())
    }

    override fun onItemClick(person: Person) {
        val dao = AppDatabase.getInstance(this).getDao()

        dao.delete(person)

        Toast.makeText(this, "Person  "+person.firstName+" deleted from favorites", Toast.LENGTH_SHORT).show()

        loadPeople { people ->
            rvFavorite.adapter = PersonAdapter(people, this)
            rvFavorite.layoutManager = LinearLayoutManager(this@FavoriteActivity)
        }
    }
}