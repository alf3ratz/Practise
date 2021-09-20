package hse.ru.practise.network

import hse.ru.practise.responses.PersonResponse
import hse.ru.practise.responses.UsersResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query


interface ApiService {


    @GET("weather?lang=ru"/*"login_generate?"*/)
    fun getPersonInfo(@Query("q") city: String, @Query("appid")appid:String): Call<PersonResponse>

    @GET("users?format=json")
    fun getUsersList(@Query("page") page:Int):Call<UsersResponse>


}