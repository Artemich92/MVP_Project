package ru.artkolest.spidertestproject.data.api

import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Path
import ru.artkolest.spidertestproject.domain.models.pictures.Gallery
import ru.artkolest.spidertestproject.domain.models.comments.DetailPhoto

interface NetworkApi {

    @GET("/3/gallery/top/top/top")
    fun getPopularPhotos(
        @Header("Authorization")
        auth: String = "Client-ID bfa94c4da5b1d5b"
    )
    : Single<Gallery>

    @GET("/3/gallery/{postId}/comments")
    fun getPost(
        @Path("postId") postId: String,
        @Header("Authorization")
        auth: String = "Client-ID bfa94c4da5b1d5b"
    ): Single<DetailPhoto>
}