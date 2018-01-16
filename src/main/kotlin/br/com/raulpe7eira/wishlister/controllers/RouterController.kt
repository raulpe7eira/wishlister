package br.com.raulpe7eira.wishlister.controllers

import br.com.raulpe7eira.wishlister.responses.*
import br.com.raulpe7eira.wishlister.services.FoursquareApiService
import br.com.raulpe7eira.wishlister.services.FoursquareAuthService
import okhttp3.HttpUrl
import okhttp3.ResponseBody
import org.springframework.core.env.Environment
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.*
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Inject

@Controller
@RequestMapping("/")
class RouterController {

    @Inject
    val environment: Environment? = null

    var foursquareAuthService: FoursquareAuthService? = null

    var foursquareApiService: FoursquareApiService? = null

    init {
        val authRetrofit = Retrofit.Builder()
                .baseUrl(FoursquareAuthService.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        foursquareAuthService = authRetrofit.create(FoursquareAuthService::class.java)

        val apiRetrofit = Retrofit.Builder()
                .baseUrl(FoursquareApiService.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        foursquareApiService = apiRetrofit.create(FoursquareApiService::class.java)
    }

    @GetMapping("/")
    fun root(model: Model): String {
        return "signin"
    }

    @GetMapping("/5XX")
    fun erro(model: Model): String {
        return "5XX"
    }

    @GetMapping("/signin")
    fun signin(model: Model): String {
        return "signin"
    }

    @PostMapping("/signin/foursquare")
    fun signinAuthentication(model: Model): String {
        val callResponseBody : Call<ResponseBody> = foursquareAuthService!!.authenticate(
                environment!!.getProperty("foursquare.client_id"),
                environment!!.getProperty("foursquare.response_type"),
                environment!!.getProperty("foursquare.redirect_uri"))
        val responseBody = callResponseBody.execute()
        if (responseBody.isSuccessful) {
            val urlRedirect : HttpUrl = responseBody.raw().request().url()
            return "redirect:" + urlRedirect.toString()
        }
        return ""
    }

    @GetMapping("/foursquare/callback")
    fun signinAuthorization(@RequestParam("code") code: String, model: Model): String {
        val callAccessTokenResponse : Call<AccessTokenResponse> = foursquareAuthService!!.authorization(
                environment!!.getProperty("foursquare.client_id"),
                environment!!.getProperty("foursquare.client_secret"),
                environment!!.getProperty("foursquare.grant_type"),
                environment!!.getProperty("foursquare.redirect_uri"),
                code)
        val accessTokenResponseBody = callAccessTokenResponse.execute()
        if (accessTokenResponseBody.isSuccessful) {
            val token = accessTokenResponseBody?.body()!!.access_token
            model.addAttribute("token", token)

            val callUserResponseBody : Call<UserResponseBody> = foursquareApiService!!.detailOfAUser(
                    environment!!.getProperty("foursquare.self"),
                    token, environment!!.getProperty("foursquare.version"))
            val userResponseBody = callUserResponseBody.execute()
            if (userResponseBody.isSuccessful) {
                model.addAttribute("user", userResponseBody.body()?.response?.user)
            } else {
                return "5XX"
            }

            val callRecentCheckinsResponseBody : Call<RecentCheckinsResponseBody> = foursquareApiService!!.recentCheckins(
                    "40.3333,-80.0088", "50", null,
                    token, environment!!.getProperty("foursquare.version"))
            val recentCheckinsResponseBordy = callRecentCheckinsResponseBody.execute()
            if (recentCheckinsResponseBordy.isSuccessful) {
                val checkinList : MutableList<Checkin>? = mutableListOf()

                var recentCheckinsResponse : RecentCheckinsResponse? = recentCheckinsResponseBordy.body()?.response
                for(checkin in recentCheckinsResponse!!.recent) {
                    val callVenuePhotosResponseBody : Call<VenuePhotosResponseBody> = foursquareApiService!!.venuePhotos(
                            checkin.venue.id,
                            environment!!.getProperty("foursquare.client_id"),
                            environment!!.getProperty("foursquare.client_secret"),
                            token, environment!!.getProperty("foursquare.version"))
                    val venuePhotosResponseBody = callVenuePhotosResponseBody.execute()
                    if (venuePhotosResponseBody.isSuccessful) {
                        checkin.venue.items = venuePhotosResponseBody.body()?.response!!.photos.items
                    } else {
                        return "5XX"
                    }
                    checkinList!!.add(checkin)
                }
                model.addAttribute("checkins", checkinList!!.toList())
            } else {
                return "5XX"
            }

            return "home"
        }
        return "signin"
    }

}