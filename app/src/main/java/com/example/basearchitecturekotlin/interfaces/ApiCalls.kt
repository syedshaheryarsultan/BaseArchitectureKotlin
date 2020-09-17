package com.example.basearchitecturekotlin.interfaces

import com.example.basearchitecturekotlin.model.PostResponse
import retrofit2.Call
import retrofit2.http.GET

interface ApiCalls {

    @get:GET("posts")
    val post: Call<List<PostResponse?>?>?

}