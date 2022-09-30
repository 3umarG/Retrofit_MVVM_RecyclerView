package com.example.retrofitmvvm.data

import com.example.retrofitmvvm.model.PostModel
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface PostInterface {
    @GET("posts")
    fun getPosts() : Call<List<PostModel>>


    @GET("posts/{id}")
    fun getSinglePost(@Path("id") id : Int) : Call<PostModel>
}