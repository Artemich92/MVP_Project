package ru.artkolest.spidertestproject.data.api

import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Query
import ru.artkolest.spidertestproject.domain.models.PhotoModel

interface NetworkApi {

    @GET("gifts")
    fun getPopularPhoto(
        @Query("profileId") profileId: Long,
        @Query("offset") page: Int
    ): Single<List<PhotoModel>> // сделать другую модель Response (с json)
}