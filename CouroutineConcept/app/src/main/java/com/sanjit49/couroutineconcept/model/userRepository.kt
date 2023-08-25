package com.sanjit49.couroutineconcept.model

import kotlinx.coroutines.delay

class userRepository {

    suspend fun getUsers():List<user>{
        delay(8000)
        val users: List<user> =listOf(
            user(1,"sanjit"),
              user(2,"nikesh")
                )
        return  users


    }
}