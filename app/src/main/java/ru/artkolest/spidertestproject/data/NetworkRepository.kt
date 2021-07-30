package ru.artkolest.spidertestproject.data

import io.reactivex.Single
import ru.artkolest.spidertestproject.data.api.NetworkApi
import ru.artkolest.spidertestproject.domain.NetworkDataSource
import ru.artkolest.spidertestproject.domain.models.pictures.Gallery
import ru.artkolest.spidertestproject.domain.models.comments.DetailPhoto
import javax.inject.Inject

class NetworkRepository @Inject constructor(
    private val api: NetworkApi,
) : NetworkDataSource {

    override fun getPhotos(): Single<Gallery> {
        return api.getPopularPhotos()
    }

    override fun getPostInfo(postId: String): Single<DetailPhoto> {
        return api.getPost(postId)
    }
}