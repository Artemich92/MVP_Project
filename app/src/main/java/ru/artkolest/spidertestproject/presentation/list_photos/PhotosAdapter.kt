package ru.artkolest.spidertestproject.presentation.list_photos

import ru.artkolest.spidertestproject.domain.models.PhotoModel

class PhotosAdapter(private var listener: Listener) {

    private val data = ArrayList<PhotoModel>()

    interface Listener {
        fun onClick(model: PhotoModel)
    }
}