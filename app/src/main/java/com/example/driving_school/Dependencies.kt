package com.example.driving_school

import android.content.Context
import androidx.room.Room

object Dependencies {
    private lateinit var applicationContext: Context
    fun init(context: Context) {
        applicationContext = context
    }
    private val appDatabase: AppDatabase by lazy {
        Room.databaseBuilder(applicationContext, AppDatabase::class.java, "student.db")
            .createFromAsset("stud.db")
            .build()
    }
    val studRepository: StudRepository by lazy { StudRepository(appDatabase.getDao()) }
}