package com.homebridge.app_sem7_challenge_friends.db

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.homebridge.app_sem7_challenge_friends.models.Person

@Dao
interface PersonDao {
    @Insert
    fun insertOne(person: Person)

    @Query("SELECT * FROM person")
    fun getAll(): List<Person>

    @Delete
    fun delete(person: Person)
}