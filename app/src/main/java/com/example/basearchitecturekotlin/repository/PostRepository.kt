package com.example.basearchitecturekotlin.repository

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.basearchitecturekotlin.interfaces.PostCallInterface
import com.example.basearchitecturekotlin.model.PostResponse
import com.example.basearchitecturekotlin.module.AppModule
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class PostRepository : PostCallInterface {

    private val apiCalls = AppModule.services

    override val posts: MutableLiveData<List<PostResponse?>?>
        get() {
            val liveData = MutableLiveData<List<PostResponse?>?>()
            val call = apiCalls.post

            call!!.enqueue(object : Callback<List<PostResponse?>?>{

                override fun onResponse(call: Call<List<PostResponse?>?>, response: Response<List<PostResponse?>?>) {
                    Log.d("Api", "Api Fetched")

                    if(response.isSuccessful){
                        liveData.value = response.body()
                    }
                }

                override fun onFailure(call: Call<List<PostResponse?>?>, t: Throwable) {
                    Log.d("Api", "Api Not Fetched" + t.message)
                }

            })
            return liveData
        }

    companion object{
        @JvmStatic
        var instance: PostRepository? = null
        get() {
            if(field == null){
                field = PostRepository()
            }
            return field
        }
        private set
    }
}