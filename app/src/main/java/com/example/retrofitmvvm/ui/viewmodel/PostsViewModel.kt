package com.example.retrofitmvvm.ui.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.retrofitmvvm.model.PostModel
import com.example.retrofitmvvm.repo.PostRepository
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class PostsViewModel : ViewModel() {
    private val _mutableLiveData = MutableLiveData<List<PostModel>>()
    var posts = _mutableLiveData as LiveData<List<PostModel>>

    private val call: Call<List<PostModel>> = PostRepository.getPosts()
    fun getPosts() {
        call.enqueue(object : Callback<List<PostModel>> {
            override fun onResponse(
                call: Call<List<PostModel>>,
                response: Response<List<PostModel>>
            ) {
                _mutableLiveData.value = response.body() as List<PostModel>
            }

            override fun onFailure(call: Call<List<PostModel>>, t: Throwable) {
                _mutableLiveData.value = listOf()
            }
        })
    }
}