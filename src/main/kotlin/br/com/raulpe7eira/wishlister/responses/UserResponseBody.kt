package br.com.raulpe7eira.wishlister.responses

data class UserResponseBody (
        val response: UserResponse
)

data class UserResponse (
        val user: User
)

data class User (
        val id: String,
        val firstName: String,
        val lastName: String,
        val photo: Photo
)