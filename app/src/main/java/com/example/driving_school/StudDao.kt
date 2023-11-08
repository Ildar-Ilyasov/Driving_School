package com.example.driving_school

import androidx.room.Dao
import androidx.room.Query

@Dao
interface StudDao{
    @Query("SELECT id FROM Groups")
    suspend fun getGroups(): List<Int>

    @Query("SELECT * FROM Students WHERE `Group`=:id")
    suspend fun getStudentsByGroup(id: Int): List<StudentsEntity>

    @Query("SELECT * FROM Students WHERE id=:id")
    suspend fun getStudentById(id: Int): StudentsEntity
}