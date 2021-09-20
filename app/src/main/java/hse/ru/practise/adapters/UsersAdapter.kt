package hse.ru.practise.adapters


import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.FragmentActivity
import androidx.recyclerview.widget.RecyclerView
import hse.ru.practise.R
import hse.ru.practise.databinding.UserContainerBinding
import hse.ru.practise.listeners.UserListener
import hse.ru.practise.models.UserEntity


class UsersAdapter(events_: List<UserEntity>, weatherListener_: UserListener) :
    RecyclerView.Adapter<UsersAdapter.UsersViewHolder>() {

    private var hourlyWeather: List<UserEntity> = events_
    private var layoutInflater: LayoutInflater? = null
    var eventsListener: UserListener = weatherListener_

    inner class UsersViewHolder(itemLayoutBinding: UserContainerBinding) :
        RecyclerView.ViewHolder(itemLayoutBinding.root) {
        private var containerBinding: UserContainerBinding? = null

        init {
            this.containerBinding = itemLayoutBinding
        }

        fun bindEvent(userEntity: UserEntity) {
            if (userEntity.bio.isEmpty()) {
                userEntity.bio = "Пользователь не добавил биографию :("
            }

            containerBinding?.userInfo = userEntity

            containerBinding?.executePendingBindings()
            if (containerBinding?.root != null)
                itemView.setOnClickListener {
                    eventsListener.onUserClicked(userEntity)
                }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UsersViewHolder {
        if (layoutInflater == null)
            layoutInflater = LayoutInflater.from(parent.context)
        val binding: UserContainerBinding =
            DataBindingUtil.inflate(layoutInflater!!, R.layout.user_container, parent, false)
        return UsersViewHolder(binding)
    }

    override fun onBindViewHolder(holder: UsersViewHolder, position: Int) {
        holder.bindEvent(hourlyWeather[position])
    }

    override fun getItemCount(): Int {
        return hourlyWeather.size
    }
}