package ru.artkolest.spidertestproject.domain

import io.reactivex.Single
import ru.artkolest.spidertestproject.domain.models.PhotoModel

interface NetworkDataSource {

    fun getPhoto(photoId: Long, page: Int): Single<List<PhotoModel>>

//    fun getPhoto(id: Long): Single<PhotoModel>
}