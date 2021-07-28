package ru.artkolest.spidertestproject.data

import io.reactivex.Single
import ru.artkolest.spidertestproject.data.api.NetworkApi
import ru.artkolest.spidertestproject.domain.NetworkDataSource
import ru.artkolest.spidertestproject.domain.models.PhotoModel
import javax.inject.Inject

class NetworkRepository @Inject constructor(
    private val api: NetworkApi,
) : NetworkDataSource {

    // популярные фото getPopularPhoto(): Single<List<PhotoModel>>
    override fun getPhoto(photoId: Long, page: Int): Single<List<PhotoModel>> {
        return api.getPopularPhoto(photoId, page)
    }

    // одно фото fun getPhoto(id: Long): Single<PhotoModel>
//    override fun getPhoto(id: Long): Single<PhotoModel> {
//        return api.getPhoto()
//    }
}