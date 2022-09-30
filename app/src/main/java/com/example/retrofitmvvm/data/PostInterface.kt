package com.example.retrofitmvvm.data

import com.example.retrofitmvvm.model.PostModel
import retrofit2.Call
import retrofit2.http.*

interface PostInterface {
    @GET("posts")
    fun getPosts(): Call<List<PostModel>>


    @GET("posts/{id}")
    fun getSinglePost(@Path("id") id: Int): Call<PostModel>


    // TODO : Specific Static Header to this Method Only.
    @Headers("Auth : 555", "Platform: Android")
    @POST("posts")
    fun sendPost(
        @Body map: Map<Any, Any>
    ): Call<PostModel>


    // TODO : Send Headers Dynamically, and receive them by method parameters.
    @POST("posts")
    fun sendPost2(
        @Body map: Map<Any, Any> ,
        @Header("Type") type : String
    ): Call<PostModel>
}