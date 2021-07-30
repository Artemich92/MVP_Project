package ru.artkolest.spidertestproject.presentation.list_photos

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import kotlinx.android.synthetic.main.item_photo.view.*
import ru.artkolest.spidertestproject.R
import ru.artkolest.spidertestproject.base.extensions.onClick
import ru.artkolest.spidertestproject.domain.models.pictures.ImageEntity

class PhotoAdapter(private var listener: Listener) :
    RecyclerView.Adapter<PhotoAdapter.PhotoViewHolder>() {

    private var images = ArrayList<ImageEntity>()

    interface Listener {
        fun onClick(image: ImageEntity)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PhotoViewHolder {
        val item = LayoutInflater.from(parent.context).inflate(R.layout.item_photo, parent, false)
        return PhotoViewHolder(item)
    }

    override fun onBindViewHolder(viewHolder: PhotoViewHolder, position: Int) {
        viewHolder.bind(images[position])
        viewHolder.itemView.cvContainer.onClick {
            listener.onClick(images[position])
        }
    }

    fun setItems(images: List<ImageEntity>) {
        this.images.clear()
        this.images.addAll(images)
        this.notifyDataSetChanged()
    }

    override fun getItemCount(): Int {
        return images.size
    }

    class PhotoViewHolder(private var view: View) : RecyclerView.ViewHolder(view) {
        fun bind(image: ImageEntity) {
            setPhoto(image.link, view)
        }

        private fun setPhoto(imageUri: String, view: View) {
            Glide.with(view.context)
                .asBitmap()
                .load(imageUri)
                .placeholder(R.drawable.hourglass)
                .into(view.sivPhoto)
        }
    }
}