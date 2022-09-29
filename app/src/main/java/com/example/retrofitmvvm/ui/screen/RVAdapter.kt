package com.example.retrofitmvvm.ui.screen

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.retrofitmvvm.R
import com.example.retrofitmvvm.model.PostModel

class RVAdapter(private val listOfPost: List<PostModel>) :
    RecyclerView.Adapter<RVAdapter.PostViewHolder>() {


    inner class PostViewHolder(v: View) : RecyclerView.ViewHolder(v) {
        private val tvTitle = v.findViewById<TextView>(R.id.tvTitle)
        private val tvId = v.findViewById<TextView>(R.id.tvId)
        private val tvBody = v.findViewById<TextView>(R.id.tvBody)

        fun bind(postModel: PostModel) {
            tvTitle.text = postModel.title
            tvBody.text = postModel.body
            tvId.text = postModel.id.toString()
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_post, parent, false)
        return PostViewHolder(view)
    }

    override fun onBindViewHolder(holder: PostViewHolder, position: Int) {
        holder.bind(listOfPost[position])
    }

    override fun getItemCount(): Int {
        return listOfPost.size
    }


}