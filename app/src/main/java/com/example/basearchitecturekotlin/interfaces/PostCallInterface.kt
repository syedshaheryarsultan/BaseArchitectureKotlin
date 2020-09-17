package com.example.basearchitecturekotlin.interfaces

import androidx.lifecycle.MutableLiveData
import com.example.basearchitecturekotlin.model.PostResponse

interface PostCallInterface {

    val posts: MutableLiveData<List<PostResponse?>?>?

}