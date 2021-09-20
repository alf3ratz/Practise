package hse.ru.practise.network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ApiClient {
    companion object {
        private var retrofit: Retrofit? = null
        fun getRetrofit(): Retrofit {
            if (retrofit == null)
                retrofit = Retrofit.Builder()
                    .baseUrl("https://hyperskill.org/api/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
            return retrofit!!
        }
    }
}