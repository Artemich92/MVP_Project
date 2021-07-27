package ru.artkolest.spidertestproject.presentation.list_photos

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.item_photo.view.*
import ru.artkolest.spidertestproject.R
import ru.artkolest.spidertestproject.base.extensions.onClick
import ru.artkolest.spidertestproject.domain.models.PhotoModel

class PhotoAdapter(private var listener: Listener): RecyclerView.Adapter<PhotoAdapter.PhotoViewHolder>() {

    private var data = ArrayList<PhotoModel>()

    interface Listener {
        fun onClick(model: PhotoModel)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PhotoViewHolder {
        val item = LayoutInflater.from(parent.context).inflate(R.layout.item_photo, parent, false)
        return PhotoViewHolder(item)
    }

    override fun onBindViewHolder(viewHolder: PhotoViewHolder, position: Int) {
        viewHolder.bind(data[position])
        viewHolder.itemView.cvContainer.onClick { listener.onClick(data[position]) }
    }

    fun setItems(items: List<PhotoModel>) {
        this.data.clear()
        this.data.addAll(items)
        this.notifyDataSetChanged()
    }

    override fun getItemCount(): Int {
        return data.size
    }

    class PhotoViewHolder(photo: View) : RecyclerView.ViewHolder(photo) {
        fun bind(model: PhotoModel) {
            // TODO: 27.07.2021 реализовать
        }
    }

    private fun setPhoto(image: ByteArray?, view: View) {
        Glide.with(view.context)
            .asBitmap()
            .load(image)
            .placeholder(R.drawable.ic_launcher_background)
            .circleCrop()
            .into(view.sivPhoto)
    }
}