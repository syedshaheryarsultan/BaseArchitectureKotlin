package com.example.basearchitecturekotlin.model

import com.google.gson.annotations.SerializedName

data class PostResponse(

    @SerializedName("userId")
    var userId: String? = "",

    @SerializedName("id")
    var id: String? = "",

    @SerializedName("title")
    var title: String? = "",

    @SerializedName("body")
    var body: String? = ""
)