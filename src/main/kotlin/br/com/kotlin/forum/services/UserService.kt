package br.com.kotlin.forum.services

import br.com.kotlin.forum.model.User
import org.springframework.stereotype.Service
import java.util.*

@Service
class UserService(var users: List<User>) {

    init {
        val user = User(
            id = 1,
            name = "User 1",
            email = "user1@gmail.com",
        )
        users = Arrays.asList(user)
    }

    fun findById(id: Long): User {
        return users.stream().filter({
                c -> c.id == id
        }).findFirst().get()
    }
}
