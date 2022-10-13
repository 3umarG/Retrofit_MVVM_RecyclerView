package com.example.retrofitmvvm.repo

import com.example.retrofitmvvm.data.PostClient
import com.example.retrofitmvvm.model.PostModel
import retrofit2.Call
import retrofit2.Response

class PostRepository private constructor() {

    companion object {
        suspend fun getPosts(): Response<List<PostModel>> = PostClient.api.getPosts()

        fun sendPost(map: Map<Any, Any>): Call<PostModel> = PostClient.api.sendPost(map)
    }
}