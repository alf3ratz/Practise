package hse.ru.practise.ui.fragments

import android.R
import android.graphics.drawable.Drawable
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.bumptech.glide.request.target.Target
import hse.ru.practise.databinding.FragmentPersonInfoBinding
import hse.ru.practise.models.UserEntity


class PersonInfoFragment : Fragment() {

    private lateinit var binding: FragmentPersonInfoBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentPersonInfoBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val bundle = this.arguments
        binding.apply {
            val options: RequestOptions = RequestOptions()
                .centerCrop()
                .placeholder(R.mipmap.sym_def_app_icon)
                .error(R.mipmap.sym_def_app_icon)
            userInfo = bundle!!.getSerializable("user") as UserEntity?
            Glide.with(requireActivity()).load(userInfo!!.photoUrl).apply(options).into(userImage)
            backButton.setOnClickListener {
                if (parentFragmentManager.backStackEntryCount > 0) {
                    parentFragmentManager.popBackStackImmediate()
                }
            }
        }

    }
}