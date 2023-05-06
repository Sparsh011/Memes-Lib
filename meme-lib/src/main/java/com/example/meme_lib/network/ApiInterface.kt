package com.example.meme_lib.network

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiInterface {
    @GET("gimme/{count}")
    suspend fun getMemes(
        @Path("count") limit: Int
    ) : Response<Memes>

    @GET("gimme")
    suspend fun getMeme() : Response<Meme>
}