package hse.ru.practise.adapters

import android.net.Uri
import android.util.Log
import android.widget.ImageView
import android.widget.Toast
import androidx.databinding.BindingAdapter
import com.squareup.picasso.Picasso
import com.squareup.picasso.Callback
import hse.ru.practise.R


@BindingAdapter("android:imageUrl")
fun setImageUrl(imageView: ImageView, URL: String) {
    try {
//        GlideTo
//        GlideToVectorYou
//            .init()
//            .with(this.context)
//            .setPlaceHolder(R.drawable.loading, R.drawable.actual)
//            .load(Uri.parse(url), this)
        Picasso.get().load(URL).noFade().into(imageView, object : Callback {
            override fun onSuccess() {
                imageView.animate().start()
            }

            override fun onError(e: Exception) {
                Log.i("fal","dsad")
            }
        })
    } catch (e: Exception) {
    }
}
