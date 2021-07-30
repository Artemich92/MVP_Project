package ru.artkolest.spidertestproject.domain.models.pictures

data class ImageEntity(
    val id: Int,
    val link: String,
    val author: String,
    val post_id: String
)
