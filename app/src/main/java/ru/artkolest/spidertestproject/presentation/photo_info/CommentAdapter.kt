package ru.artkolest.spidertestproject.presentation.photo_info

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_comment.view.*
import ru.artkolest.spidertestproject.R
import ru.artkolest.spidertestproject.domain.models.comments.Comments

class CommentAdapter() : RecyclerView.Adapter<CommentAdapter.CommentViewHolder>() {

    private var data = ArrayList<Comments>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CommentViewHolder {
        val item = LayoutInflater.from(parent.context).inflate(R.layout.item_comment, parent, false)
        return CommentViewHolder(item)
    }

    override fun onBindViewHolder(viewHolder: CommentViewHolder, position: Int) {
        viewHolder.bind(data[position])
    }

    fun setComment(comments: List<Comments>) {
        this.data.clear()
        this.data.addAll(comments)
        this.notifyDataSetChanged()
    }

    override fun getItemCount(): Int {
        return data.size
    }

    class CommentViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        fun bind(comment: Comments) {
            itemView.tvComment.text = comment.comment
        }
    }
}