package br.com.raulpe7eira.wishlister.services

import br.com.raulpe7eira.wishlister.responses.RecentCheckinsResponseBody
import br.com.raulpe7eira.wishlister.responses.UserResponseBody
import br.com.raulpe7eira.wishlister.responses.VenuePhotosResponseBody
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface FoursquareApiService {

    companion object {
        val BASE_URL = "https://api.foursquare.com/"
    }

    @GET("/v2/users/{USER_ID}")
    fun detailOfAUser(
            @Path("USER_ID") user_id: String,
            @Query("oauth_token") oauth_token: String,
            @Query("v") version: String
    ) : Call<UserResponseBody>

    @GET("/v2/checkins/recent")
    fun recentCheckins(
            @Query("ll") location: String,
            @Query("limit") limit_result: String,
            @Query("afterTimestamp") after_timestamp: String?,
            @Query("oauth_token") oauth_token: String,
            @Query("v") version: String
    ) : Call<RecentCheckinsResponseBody>

    @GET("/v2/venues/{VENUE_ID}/photos")
    fun venuePhotos(
            @Path("VENUE_ID") venue_id: String,
            @Query("client_id") client_id: String,
            @Query("client_secret") client_secret: String,
            @Query("oauth_token") oauth_token: String,
            @Query("v") version: String
    ) : Call<VenuePhotosResponseBody>

}