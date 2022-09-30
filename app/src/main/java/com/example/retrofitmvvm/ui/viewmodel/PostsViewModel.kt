package com.example.retrofitmvvm.ui.viewmodel

import android.app.Application
import android.widget.Toast
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.retrofitmvvm.model.PostModel
import com.example.retrofitmvvm.repo.PostRepository
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class PostsViewModel(private val application: Application) : ViewModel() {
    private val _mutableLiveData = MutableLiveData<List<PostModel>>(listOf())
    var posts = _mutableLiveData as LiveData<List<PostModel>>

    private val _sendMutableLiveData = MutableLiveData<PostModel?>()
    var sendLiveData = _sendMutableLiveData

    private val call: Call<List<PostModel>> = PostRepository.getPosts()
    fun getPosts() {
        call.enqueue(object : Callback<List<PostModel>> {
            override fun onResponse(
                call: Call<List<PostModel>>,
                response: Response<List<PostModel>>
            ) {
                if (response.isSuccessful) {
                    _mutableLiveData.value = response.body() as List<PostModel>
                } else {
                    Toast.makeText(
                        application.applicationContext,
                        "404 ERROR !!",
                        Toast.LENGTH_LONG
                    ).show()
                }
            }

            override fun onFailure(call: Call<List<PostModel>>, t: Throwable) {
                _mutableLiveData.value = listOf()
            }
        })
    }


    fun sendPosts(map: Map<Any, Any>) {
        val sendCall = PostRepository.sendPost(map)
        sendCall.enqueue(object : Callback<PostModel> {
            override fun onResponse(call: Call<PostModel>, response: Response<PostModel>) {
                if (response.isSuccessful) {
                    _sendMutableLiveData.value = response.body()
                } else {
                    _sendMutableLiveData.value = null
                }
            }

            override fun onFailure(call: Call<PostModel>, t: Throwable) {
                _sendMutableLiveData.value = null
            }
        })
    }
}