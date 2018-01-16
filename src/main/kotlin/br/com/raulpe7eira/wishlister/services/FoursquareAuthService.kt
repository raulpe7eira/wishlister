package br.com.raulpe7eira.wishlister.services

import br.com.raulpe7eira.wishlister.responses.AccessTokenResponse
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface FoursquareAuthService {

    companion object {
        val BASE_URL = "https://foursquare.com/"
    }

    @GET("/oauth2/authenticate")
    fun authenticate(
            @Query("client_id") client_id: String,
            @Query("response_type") response_type: String,
            @Query("redirect_uri") redirect_uri: String
    ): Call<ResponseBody>

    @GET("/oauth2/access_token")
    fun authorization(
            @Query("client_id") client_id: String,
            @Query("client_secret") client_secret: String,
            @Query("grant_type") grant_type: String,
            @Query("redirect_uri") redirect_uri: String,
            @Query(value = "code", encoded = false) code: String
    ): Call<AccessTokenResponse>

}