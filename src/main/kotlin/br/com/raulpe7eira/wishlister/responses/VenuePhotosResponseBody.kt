package br.com.raulpe7eira.wishlister.responses

data class VenuePhotosResponseBody (
        val response: VenuePhotosResponse
)

data class VenuePhotosResponse (
        val photos: PhotosResponse
)
