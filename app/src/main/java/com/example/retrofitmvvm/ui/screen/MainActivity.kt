package com.example.retrofitmvvm.ui.screen

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.retrofitmvvm.R
import com.example.retrofitmvvm.ui.viewmodel.PostsViewModel

class MainActivity : AppCompatActivity() {
    private lateinit var recyclerView: RecyclerView
    private lateinit var postsViewModel: PostsViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView = findViewById(R.id.recyclerView)
        postsViewModel = ViewModelProvider(this)[PostsViewModel::class.java]

        postsViewModel.getPosts()

        postsViewModel.posts.observe(this
        ) {
            val rvAdapter = RVAdapter(it!!)
            recyclerView.adapter = rvAdapter
            recyclerView.layoutManager = LinearLayoutManager(this@MainActivity)
        }
    }
}