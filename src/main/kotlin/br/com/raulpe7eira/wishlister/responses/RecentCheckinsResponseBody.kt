package br.com.raulpe7eira.wishlister.responses

data class RecentCheckinsResponseBody (
        val response: RecentCheckinsResponse
)

data class RecentCheckinsResponse (
        val recent: List<Checkin>
)

data class Checkin (
        val id: String,
        val user: User,
        val venue: Venue,
        val photos: PhotosResponse
)

data class Venue (
        val id: String,
        val name: String,
        var items: List<Photo>?
)