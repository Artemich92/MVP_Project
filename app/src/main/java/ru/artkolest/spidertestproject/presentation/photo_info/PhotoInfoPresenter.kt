package ru.artkolest.spidertestproject.presentation.photo_info

import ru.artkolest.spidertestproject.base.BasePresenter
import ru.artkolest.spidertestproject.di.scopes.PhotoInfoScope
import ru.artkolest.spidertestproject.presentation.list_photos.PhotosContract
import javax.inject.Inject

@PhotoInfoScope
class PhotoInfoPresenter @Inject constructor()
    :  BasePresenter<PhotoInfoContract.View>(), PhotoInfoContract.Presenter{

    override lateinit var view: PhotoInfoContract.View

    override fun start() = Unit

}
