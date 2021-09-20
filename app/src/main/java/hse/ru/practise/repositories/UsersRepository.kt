package hse.ru.practise.repositories

import android.util.Log
import androidx.annotation.NonNull
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import hse.ru.practise.network.ApiClient
import hse.ru.practise.network.ApiService
import hse.ru.practise.responses.PersonResponse
import hse.ru.practise.responses.UsersResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class UsersRepository {
    private var apiService: ApiService = ApiClient.getRetrofit().create(ApiService::class.java)

    fun getPersonInfo(city: String, apiKey: String): LiveData<PersonResponse> {
        val data: MutableLiveData<PersonResponse> = MutableLiveData()
        apiService.getPersonInfo(city, apiKey).enqueue(object : Callback<PersonResponse> {
            override fun onFailure(@NonNull call: Call<PersonResponse>, t: Throwable) {
                data.value = null
                Log.i("fal", "upalo\n${call.request().body()}")
            }

            override fun onResponse(
                @NonNull call: Call<PersonResponse>,
                @NonNull response: Response<PersonResponse>
            ) {
                data.value = response.body()
                Log.i("fal", "ne upalo\n${response.isSuccessful}")
            }
        })
        return data
    }
    fun getUsersList(page:Int): LiveData<UsersResponse>{
        val data: MutableLiveData<UsersResponse> = MutableLiveData()
        apiService.getUsersList(page).enqueue(object : Callback<UsersResponse> {
            override fun onFailure(@NonNull call: Call<UsersResponse>, t: Throwable) {
                data.value = null
                Log.i("fal", "upalo\n${call.request().body()}")
            }

            override fun onResponse(
                @NonNull call: Call<UsersResponse>,
                @NonNull response: Response<UsersResponse>
            ) {
                data.value = response.body()
                Log.i("fal", "ne upalo\n${response.isSuccessful}")
            }
        })
        return data
    }


}