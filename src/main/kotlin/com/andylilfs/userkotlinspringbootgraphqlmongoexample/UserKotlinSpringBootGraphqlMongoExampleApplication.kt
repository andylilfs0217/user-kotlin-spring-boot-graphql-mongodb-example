package com.andylilfs.userkotlinspringbootgraphqlmongoexample

import com.andylilfs.userkotlinspringbootgraphqlmongoexample.model.AppUser
import com.andylilfs.userkotlinspringbootgraphqlmongoexample.resolver.UserResolver
import jakarta.annotation.PostConstruct
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import java.util.*

@SpringBootApplication
class UserKotlinSpringBootGraphqlMongoExampleApplication(private val userResolver: UserResolver) {

	@PostConstruct
	private final fun initializeDummyData() {
		val dataCount = 10000

		for (i in 0 until dataCount) {
			val firstName = generateRandomString(8)
			val lastName = generateRandomString(8)
			val email = "${firstName.lowercase()}.${lastName.lowercase()}@example.com"
			val username = "${firstName.lowercase()}${lastName.lowercase()}"
			val password = generateRandomString(10)

			userResolver.createUser(firstName, lastName, email, username, password)
		}
	}

	private fun generateRandomString(length: Int): String {
		val characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789"
		val result = StringBuilder()
		val random = Random()
		for (i in 0 until length) {
			val index = random.nextInt(characters.length)
			result.append(characters[index])
		}
		return result.toString()
	}

	companion object {
		@JvmStatic
		fun main(args: Array<String>) {
			runApplication<UserKotlinSpringBootGraphqlMongoExampleApplication>(*args)
		}
	}
}

//fun main(args: Array<String>) {
//	runApplication<UserKotlinSpringBootGraphqlMongoExampleApplication>(*args)
//}
