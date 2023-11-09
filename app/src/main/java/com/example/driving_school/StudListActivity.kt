package com.example.driving_school

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import java.util.Locale

class StudListActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val viewModel = StudListVM(Dependencies.studRepository)
        viewModel.getList(intent.getIntExtra("id", -1))
        setContent {
            var list = remember {
                mutableStateOf(listOf(StudentsEntity(0, "", "", "", "", 1, "", "", "", "")))
            }
            viewModel.studList.observe(this) {
                list.value = it
            }
            val textState = remember { mutableStateOf(TextFieldValue("")) }

                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(Color.hsv(217f,0.28f,0.51f))
                ) {
                    Column() {
                        SearchView(state = textState)

                        StudentsList(state = textState, list = list, context = this@StudListActivity)
                        }
                }
        }
    }
}

@Composable
fun StudentsList(state: MutableState<TextFieldValue>, list: MutableState<List<StudentsEntity>>, context: Context) {
    val students = list
    if (students == null){
        Toast.makeText(context, "ОШИБКА", Toast.LENGTH_SHORT).show()
        return
    }
    var filteredGroups: List<StudentsEntity>
    LazyColumn(modifier = Modifier.fillMaxWidth()) {
        val searchedText = state.value.text
        filteredGroups = if (searchedText.isEmpty()) {
            students.value
        } else {
            val resultList = ArrayList<StudentsEntity>()
            for (stud in students.value) {
                if (stud.name.lowercase(Locale.getDefault())
                    .contains(searchedText.lowercase(Locale.getDefault()))
                    ) {
                    resultList.add(stud)
                }
            }
            resultList
        }
        items(filteredGroups) { filteredGroup ->
            ListItem(
                filteredGroup,
                context
            )
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ListItem(student: StudentsEntity, context: Context) {
    Card(
        elevation = CardDefaults.cardElevation(defaultElevation = 10.dp),
        border = BorderStroke(0.5.dp, Color.DarkGray),
        shape = RoundedCornerShape(10.dp),
        modifier = Modifier
            .fillMaxWidth()
            .defaultMinSize(minHeight = 30.dp),
        onClick = {
            val intent: Intent = Intent(context, MainActivity2::class.java)
            intent.putExtra("id", student.id)
            context.startActivity(intent)
        }
    ) {
        Box(contentAlignment = Alignment.Center, modifier = Modifier.fillMaxSize()) {
            CustomText(text = student.name)
        }
    }
}