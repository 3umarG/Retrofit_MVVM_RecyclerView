package com.example.retrofitmvvm.data

import com.example.retrofitmvvm.model.PostModel
import retrofit2.Call
import retrofit2.http.GET

interface PostInterface {
    @GET("posts")
    fun getPosts() : Call<List<PostModel>>
}