package com.example.driving_school

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.Divider
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

class MainActivity2 : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val viewModel = MainActivity2VM(Dependencies.studRepository)
        viewModel.getStudentById(intent.getIntExtra("id", -1))

        setContent {
            var student by remember{
                mutableStateOf(StudentsEntity(0, "", "", "", "", 1, "", "", "", ""))
            }
            viewModel.student.observe(this){
                student = it
            }
            Screen(student)
        }
    }

    @Composable
    fun Screen(student: StudentsEntity){
        Box (modifier = Modifier
            .fillMaxSize()
            .background(Color.hsv(217f,0.28f,0.51f))){
            Card(
                border = BorderStroke(3.dp, Color.DarkGray),
                shape = RoundedCornerShape(10.dp),
                modifier = Modifier
                    .fillMaxSize()
                    .padding(15.dp),
            ){
                Box(modifier = Modifier.padding(7.dp)){
                    Column (verticalArrangement = Arrangement.spacedBy(10.dp)){
                        CustomText(text = student.name)
                        CustomText(text = student.data)
                        CustomText(text = student.category)
                        Divider()
                        CustomText(text = student.theory)
                        Divider()
                        CustomText(text = student.medCertificate)
                        Divider()
                        CustomText(text = student.trainingPeriod)
                        Divider()
                        CustomText(text = student.theoryExam)
                        Divider()
                        CustomText(text = student.drivingTest)
                    }
                }
            }
            Box (
                contentAlignment = Alignment.BottomCenter,
                modifier = Modifier.fillMaxSize()
            ) {
                Button(
                    border = BorderStroke(3.dp, Color.DarkGray),
                    onClick = { finish() },
                    colors = ButtonDefaults.buttonColors(containerColor = Color.hsv(277f,0.06f,0.93f), contentColor = Color.Black)
                ) {
                    CustomText("Назад")
                }
            }
        }
    }
}
