package com.example.retrofitmvvm.repo

import com.example.retrofitmvvm.data.PostClient
import com.example.retrofitmvvm.model.PostModel
import retrofit2.Call

class PostRepository private constructor(){
    companion object {
        fun getPosts() : Call<List<PostModel>> = PostClient.getInstance().getPosts()
    }
}