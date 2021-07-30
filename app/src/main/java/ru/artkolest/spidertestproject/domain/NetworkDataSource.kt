package ru.artkolest.spidertestproject.domain

import io.reactivex.Single
import ru.artkolest.spidertestproject.domain.models.pictures.Gallery
import ru.artkolest.spidertestproject.domain.models.comments.DetailPhoto

interface NetworkDataSource {

    fun getPhotos(): Single<Gallery>

    fun getPostInfo(postId: String): Single<DetailPhoto>
}