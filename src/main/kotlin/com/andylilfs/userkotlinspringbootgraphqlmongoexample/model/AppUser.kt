package com.andylilfs.userkotlinspringbootgraphqlmongoexample.model

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document

@Document("app-user")
data class AppUser(
  @Id
  val id: Long? = null,
  var firstName: String,
  var lastName: String,
  val email: String,
  val username: String,
  var password: String,
  var isLoggedIn: Boolean = false
)
