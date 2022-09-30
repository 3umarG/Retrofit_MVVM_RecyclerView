package com.example.retrofitmvvm.data

import com.example.retrofitmvvm.model.PostModel
import com.example.retrofitmvvm.utils.Constants
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object PostClient {

    private val retrofitBuilder by lazy {
        Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    val api: PostInterface by lazy {
        retrofitBuilder.create(PostInterface::class.java)
    }
}