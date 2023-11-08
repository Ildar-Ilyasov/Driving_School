package com.example.driving_school

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class StudRepository(private val studDao: StudDao){
    suspend fun getGroups(): List<Int>{
        return withContext(Dispatchers.IO){
            return@withContext studDao.getGroups()
        }
    }

    suspend fun getStudentsByGroup(id: Int): List<StudentsEntity>{
        return withContext(Dispatchers.IO){
            return@withContext studDao.getStudentsByGroup(id)
        }
    }
    suspend fun getStudentById(id: Int): StudentsEntity{
        return withContext(Dispatchers.IO) {
            return@withContext studDao.getStudentById(id)
        }
    }
}