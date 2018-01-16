package br.com.raulpe7eira.wishlister.responses

data class WishlistResponseBody (
        val groups: List<Wish>
)

data class WishlistResponse (
        val type: String,
        val items: List<Wish>
)

data class Wish (
        val name: String
)