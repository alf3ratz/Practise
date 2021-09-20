package hse.ru.practise.viewmodels

import android.app.Application
import androidx.annotation.NonNull
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import hse.ru.practise.repositories.UsersRepository
import hse.ru.practise.responses.PersonResponse
import hse.ru.practise.responses.UsersResponse


class UsersViewModel(@NonNull application: Application) : AndroidViewModel(application) {
    private var usersRepository: UsersRepository =
        UsersRepository()

    fun getPersonInfo(city:String,apiKey:String): LiveData<PersonResponse> {
        return usersRepository.getPersonInfo(city,apiKey)
    }
    fun getUsersList(page:Int): LiveData<UsersResponse>{
        return usersRepository.getUsersList(page)
    }




}