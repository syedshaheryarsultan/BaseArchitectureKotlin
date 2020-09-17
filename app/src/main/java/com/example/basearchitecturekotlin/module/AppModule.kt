package com.example.basearchitecturekotlin.module

import com.example.basearchitecturekotlin.interfaces.ApiCalls
import com.example.basearchitecturekotlin.urls.ApiUrls.BASE_URL
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

object AppModule {

    private var retrofit : Retrofit? = null

    private val client = OkHttpClient.Builder()
        .connectTimeout(1, TimeUnit.MINUTES)
        .readTimeout(1, TimeUnit.MINUTES)
        .build()

    @JvmStatic
    val services:ApiCalls
    get(){
        if(retrofit == null){
            retrofit = Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .client(client)
                .build()
        }
        return retrofit!!.create(ApiCalls::class.java)
    }

}