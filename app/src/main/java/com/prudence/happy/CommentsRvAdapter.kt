package com.prudence.happy

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.prudence.happy.databinding.CommentListItemBinding
import com.prudence.happy.databinding.PostListItemsBinding

class CommentsRvAdapter(var commentList: List<Comment>) : RecyclerView.Adapter<CommentViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CommentViewHolder {
        var binding=CommentListItemBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return  CommentViewHolder(binding)
    }
    override fun onBindViewHolder(holder: CommentViewHolder,position: Int) {
        var currentComment = commentList.get(position)
        holder.binding.tvpostId.text = currentComment.postId.toString()
        holder.binding.tvid.text = currentComment.id.toString()
        holder.binding.tvemail.text = currentComment.email
        holder.binding.tvname.text = currentComment.name
        holder.binding.tvbodyy.text=currentComment.body
        val context=holder.itemView.context
        holder.binding.cvComment.setOnClickListener {
            val intent= Intent(context,CommentsActivity::class.java)
            intent.putExtra("COMMENT_ID",currentComment.id)
            context.startActivity(intent)
        }

    }

    override fun getItemCount(): Int {
        return commentList.size
    }

}

class CommentViewHolder(val binding: CommentListItemBinding): RecyclerView.ViewHolder(binding.root)

