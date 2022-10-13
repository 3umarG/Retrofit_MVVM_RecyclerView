package com.example.retrofitmvvm.ui.screen

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ProgressBar
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.retrofitmvvm.R
import com.example.retrofitmvvm.model.PostModel
import com.example.retrofitmvvm.repo.PostRepository
import com.example.retrofitmvvm.ui.viewmodel.PostViewModelFactory
import com.example.retrofitmvvm.ui.viewmodel.PostsViewModel
import kotlinx.coroutines.*
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    private lateinit var recyclerView: RecyclerView
    private lateinit var postsViewModel: PostsViewModel
    private lateinit var postViewModelFactory: PostViewModelFactory
    private lateinit var progressBar: ProgressBar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView = findViewById(R.id.recyclerView)
        postViewModelFactory = PostViewModelFactory(application)
        progressBar = findViewById(R.id.progressBar)
        postsViewModel = ViewModelProvider(this, postViewModelFactory)[PostsViewModel::class.java]

/*
        lifecycleScope.launch(Dispatchers.Main) {

            var response: Deferred<Response<List<PostModel>>>? = null

            recyclerView.visibility = View.INVISIBLE
            progressBar.visibility = View.VISIBLE

            withContext(Dispatchers.IO) {
                response = async { PostRepository.getPosts() }
            }

            if (response?.await()?.isSuccessful == true) {
                recyclerView.visibility = View.VISIBLE
                progressBar.visibility = View.INVISIBLE

                val rvAdapter = RVAdapter(response?.await()?.body()!!)
                recyclerView.adapter = rvAdapter
                recyclerView.layoutManager = LinearLayoutManager(this@MainActivity)
            }
        }

 */
        lifecycleScope.launch(Dispatchers.Main) {


            recyclerView.visibility = View.INVISIBLE
            progressBar.visibility = View.VISIBLE


            val job = launch {
                withContext(Dispatchers.IO) {
                    postsViewModel.getPosts()
                }
            }

            job.join()
            postsViewModel.posts.observe(
                this@MainActivity
            ) { posts ->
                val rvAdapter = RVAdapter(posts!!)
                recyclerView.adapter = rvAdapter
                recyclerView.layoutManager = LinearLayoutManager(this@MainActivity)
                recyclerView.visibility = View.VISIBLE
                progressBar.visibility = View.INVISIBLE
            }

        }


    }
}