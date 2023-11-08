package com.example.driving_school

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class StudListVM(val studRepository: StudRepository): ViewModel() {
    var studList: MutableLiveData<List<StudentsEntity>> = MutableLiveData()

    fun getList(id: Int){
        viewModelScope.launch {
            studList.value = studRepository.getStudentsByGroup(id)
        }
    }
}