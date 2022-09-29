package com.example.retrofitmvvm.data

import com.example.retrofitmvvm.model.PostModel
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class PostClient private constructor() {


    private var postInterface: PostInterface

    init {
        val retrofitBuilder = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        postInterface = retrofitBuilder.create(PostInterface::class.java)
    }

    companion object {
        private const val BASE_URL = "https://jsonplaceholder.typicode.com/"
        private var INSTANCE = PostClient()

        fun getInstance(): PostClient {
            return INSTANCE
        }
    }



    fun getPosts(): Call<List<PostModel>> {
        return postInterface.getPosts()
    }


}