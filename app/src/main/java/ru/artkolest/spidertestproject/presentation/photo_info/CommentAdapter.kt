package ru.artkolest.spidertestproject.presentation.photo_info

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.item_comment.view.*
import kotlinx.android.synthetic.main.item_photo.view.*
import kotlinx.android.synthetic.main.item_photo.view.cvContainer
import ru.artkolest.spidertestproject.R
import ru.artkolest.spidertestproject.base.extensions.onClick
import ru.artkolest.spidertestproject.domain.models.PhotoModel

class CommentAdapter(private var listener: Listener)
    : RecyclerView.Adapter<CommentAdapter.CommentViewHolder>() {

    private var data = ArrayList<PhotoModel>()

    interface Listener {
        fun onClick(model: PhotoModel)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CommentViewHolder {
        val item = LayoutInflater.from(parent.context).inflate(R.layout.item_comment, parent, false)
        return CommentViewHolder(item)
    }

    override fun onBindViewHolder(viewHolder: CommentViewHolder, position: Int) {
        viewHolder.bind(data[position])
        viewHolder.itemView.cvContainer.onClick { listener.onClick(data[position]) }
    }

    fun setComment(items: List<PhotoModel>) {
        this.data.clear()
        this.data.addAll(items)
        this.notifyDataSetChanged()
    }

    override fun getItemCount(): Int {
        return data.size
    }

    class CommentViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        fun bind(model: PhotoModel) {
            // TODO: 27.07.2021 реализовать
            ///itemView.tvComment.text = model.comment
        }
    }

}