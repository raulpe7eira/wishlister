package br.com.raulpe7eira.wishlister.responses

data class PhotosResponse (
        val items: List<Photo>
)

data class Photo (
        val prefix: String,
        val suffix: String
)
