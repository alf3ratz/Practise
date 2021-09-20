package hse.ru.practise.listeners

import hse.ru.practise.models.UserEntity

interface UserListener {
    fun onUserClicked(userEntity: UserEntity)
}