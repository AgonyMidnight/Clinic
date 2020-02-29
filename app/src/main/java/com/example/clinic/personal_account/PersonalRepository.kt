package com.example.clinic.personal_account

interface PersonalRepository {
    suspend fun loadData(UserId: String) :Personal?

    class Personal(
        UserId: String,
        FirstName: String,
        SecondName: String,
        FatherName: String,
        Status: String
    )
}