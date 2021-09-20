package hse.ru.practise.ui.fragments

import android.R.id
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
import hse.ru.practise.R
import hse.ru.practise.adapters.UsersAdapter
import hse.ru.practise.databinding.FragmentMainBinding
import hse.ru.practise.listeners.UserListener
import hse.ru.practise.models.UserEntity
import hse.ru.practise.responses.UsersResponse
import hse.ru.practise.viewmodels.UsersViewModel


class MainFragment : Fragment(), UserListener {
    private lateinit var binding: FragmentMainBinding
    private lateinit var viewModel: UsersViewModel
    private var users: ArrayList<UserEntity> = ArrayList()
    private var currentPage: Int = 1
    private var totalAvailablePages: Int = 0

    private lateinit var usersAdapter: UsersAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentMainBinding.inflate(inflater, container, false)
        viewModel = ViewModelProvider(this).get(UsersViewModel::class.java)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        usersAdapter = UsersAdapter(users, this)
        binding.apply {
            usersRecyclerView.adapter = usersAdapter
            invalidateAll()
        }
        binding.usersRecyclerView.addOnScrollListener(object :
            RecyclerView.OnScrollListener() {
            override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                super.onScrolled(recyclerView, dx, dy)
                if (!binding.usersRecyclerView.canScrollVertically(1)) {
                    //if (currentPage <= totalAvailablePages) {
                        currentPage++
                        getUsersList()
                    //}
                }
            }
        })
        getUsersList()
    }

    private fun getUsersList() {
        viewModel.getUsersList(currentPage).observe(requireActivity(), { t: UsersResponse? ->
            if (t != null) {
                //totalAvailablePages = 1//t.page!!
                if (t.users != null) {
                    val oldCount: Int = users.size
//                    for (elem in t.users!!) {
//                        elem.name = elem.name!![0].toUpperCase() + elem.name!!.substring(
//                            1,
//                            elem.name!!.length
//                        )
//                    }
                    users.addAll(t.users!!)
                    usersAdapter.notifyDataSetChanged()
                    usersAdapter.notifyItemRangeChanged(
                        oldCount,
                        users.size / 1000
                    )
                } else {
                    Toast.makeText(
                        context,
                        "Не удалось отобразить пользователей",
                        Toast.LENGTH_LONG
                    ).show()
                }
            }
        })
    }

    override fun onUserClicked(userEntity: UserEntity) {
        Toast.makeText(context, "SHEEEDH", Toast.LENGTH_LONG).show()
        val personInfo = PersonInfoFragment()
        val bundle = Bundle();
        bundle.putSerializable("user", userEntity);
        personInfo.arguments = bundle;
        //val fragmentManager = supportFragmentManager
        parentFragmentManager.beginTransaction()
            .add(this.id, personInfo)
            .addToBackStack(null)
            .replace(this.id, personInfo)//.addToBackStack(null)
            .commit()
    }


}