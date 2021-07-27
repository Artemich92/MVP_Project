package ru.artkolest.spidertestproject.presentation.list_photos

import ru.artkolest.spidertestproject.base.BasePresenter
import ru.artkolest.spidertestproject.di.scopes.PhotosScope
import javax.inject.Inject

@PhotosScope
class PhotosPresenter @Inject constructor(): BasePresenter<PhotosContract.View>(),
PhotosContract.Presenter{

    override lateinit var view: PhotosContract.View

    override fun start() = Unit

}