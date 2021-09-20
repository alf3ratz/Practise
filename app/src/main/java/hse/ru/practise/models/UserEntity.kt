package hse.ru.practise.models

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import java.io.Serializable

class UserEntity: Serializable {
    @SerializedName("fullname")
    var name:String = ""
    @SerializedName("avatar")
    var photoUrl:String = ""
    @SerializedName("bio")
    var bio:String = ""

    @SerializedName("selected_tracks")
    var projects:ArrayList<String> = ArrayList()

}