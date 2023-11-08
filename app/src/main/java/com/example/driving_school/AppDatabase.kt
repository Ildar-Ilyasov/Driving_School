package com.example.driving_school

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(
    version = 1,
    entities = [StudentsEntity::class, GroupsEntity::class]
)
abstract class AppDatabase: RoomDatabase() {
    abstract fun getDao(): StudDao
}