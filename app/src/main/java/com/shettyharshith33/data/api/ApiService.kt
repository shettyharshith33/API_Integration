package com.shettyharshith33.data.api

import com.shettyharshith33.model.Post
import retrofit2.http.GET

interface ApiService {
    @GET("posts")
    suspend fun getPosts(): List<Post>

}