package com.andylilfs.userkotlinspringbootgraphqlmongoexample.repository

import com.andylilfs.userkotlinspringbootgraphqlmongoexample.model.AppUser
import org.springframework.data.mongodb.repository.MongoRepository
import org.springframework.stereotype.Repository
import java.util.UUID

@Repository
interface UserRepository : MongoRepository<AppUser, Long> {
  fun findByEmail(email: String): AppUser?
  fun findByUsername(username: String): AppUser?
}