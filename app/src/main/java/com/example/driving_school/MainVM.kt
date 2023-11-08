package com.example.driving_school

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.sp
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class MainVM(val studRepository: StudRepository): ViewModel() {
    var groups: MutableLiveData<List<Int>> = MutableLiveData()
    fun getGroups(){
        viewModelScope.launch {
            groups.value = studRepository.getGroups()
        }
    }
}
@Composable
fun CustomText(text: String){
    Text(text = text, fontSize = 20.sp)
}