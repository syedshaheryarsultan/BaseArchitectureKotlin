package com.example.basearchitecturekotlin.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.basearchitecturekotlin.model.PostResponse
import com.example.basearchitecturekotlin.repository.PostRepository

class PostViewModel : ViewModel() {

    private var mRepo : PostRepository? = null
    private var mPost : MutableLiveData<List<PostResponse?>?>? = null

    fun init(){
        if(mPost != null){
            return
        }
        mRepo = PostRepository.instance
        mPost = mRepo!!.posts
    }

    val posts: LiveData<List<PostResponse?>?>?
    get() = mPost

}