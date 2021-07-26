package ru.artkolest.spidertestproject.domain

interface UseCase <out OutputT, in InputT> {
    fun execute(params: InputT): OutputT

    object None
}


