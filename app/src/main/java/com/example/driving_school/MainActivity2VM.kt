package com.example.driving_school

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class MainActivity2VM(val studRepository: StudRepository): ViewModel() {
    var student: MutableLiveData<StudentsEntity> = MutableLiveData()
    fun getStudentById(id : Int) {
        viewModelScope.launch {
            student.value = studRepository.getStudentById(id)
        }
    }
}