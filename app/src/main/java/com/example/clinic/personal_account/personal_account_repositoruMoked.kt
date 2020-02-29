package com.example.clinic.personal_account

import kotlinx.coroutines.delay

class personal_account_repositoruMoked :PersonalRepository {
    override  suspend fun loadData(UserId: String) :PersonalRepository.Personal{
    return  PersonalRepository.Personal (UserId = "87317", FirstName = "Иван", SecondName = "Иванов", FatherName = "Сергеевич", Status = "пациент")
    }

}