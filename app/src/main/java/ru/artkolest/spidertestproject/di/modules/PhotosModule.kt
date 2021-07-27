package ru.artkolest.spidertestproject.di.modules

import dagger.Binds
import dagger.Module
import ru.artkolest.spidertestproject.di.scopes.PhotosScope
import ru.artkolest.spidertestproject.presentation.list_photos.PhotosContract
import ru.artkolest.spidertestproject.presentation.list_photos.PhotosPresenter

@Module
interface PhotosModule {

    @PhotosScope
    @Binds
    fun presenter(presenter: PhotosPresenter): PhotosContract.Presenter



}