package com.prudence.happy

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.prudence.happy.databinding.PostListItemsBinding

class PostRvAdapter (var postList:List<Post>): RecyclerView.Adapter<PostViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostViewHolder{
        var binding=PostListItemsBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return  PostViewHolder(binding)
    }

    override fun onBindViewHolder(holder: PostViewHolder, position: Int) {
        var currentPost = postList.get(position)
        holder.binding.tvUserId.text = currentPost.userId.toString()
        holder.binding.tvId.text = currentPost.id.toString()
        holder.binding.tvTitle.text = currentPost.title
        holder.binding.tvbodyy.text = currentPost.body
        val context=holder.itemView.context
        holder.binding.cvPost.setOnClickListener {
            val intent=Intent(context,CommentsActivity::class.java)
            intent.putExtra("POST_ID",currentPost.id)
            context.startActivity(intent)
        }

    }
    override fun getItemCount(): Int {
        return postList.size
    }
}
class PostViewHolder(val binding: PostListItemsBinding): RecyclerView.ViewHolder(binding.root)

