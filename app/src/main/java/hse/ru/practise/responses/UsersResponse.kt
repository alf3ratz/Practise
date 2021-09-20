package hse.ru.practise.responses

import com.google.gson.annotations.SerializedName
import hse.ru.practise.models.UserEntity

class UsersResponse {
    @SerializedName("users")
    var users: ArrayList<UserEntity> ?=null //ArrayList()
}