package ru.artkolest.spidertestproject.domain.models.pictures


data class Gallery (
    val data: List<Data>,
    val status: Int,
    val success: Boolean
)