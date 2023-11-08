package com.example.driving_school

import androidx.room.ColumnInfo
import androidx.room.Entity

import androidx.room.PrimaryKey

@Entity(tableName = "Students")
data class StudentsEntity(
    @ColumnInfo(name = "Group") val group: Int,
    @ColumnInfo(name = "Category") val category: String,
    @ColumnInfo(name = "Theory") val theory: String,
    @ColumnInfo(name = "TheoryExam") val theoryExam: String,
    @ColumnInfo(name = "Data") val data: String,
    @PrimaryKey val id: Int,
    @ColumnInfo(name = "TrainingPeriod") val trainingPeriod: String,
    @ColumnInfo(name = "Name") val name: String,
    @ColumnInfo(name = "MedCertificate") val medCertificate: String,
    @ColumnInfo(name = "DrivingTest") val drivingTest: String
)
@Entity(tableName = "Groups")
data class GroupsEntity(
    @PrimaryKey val id: Int?)
