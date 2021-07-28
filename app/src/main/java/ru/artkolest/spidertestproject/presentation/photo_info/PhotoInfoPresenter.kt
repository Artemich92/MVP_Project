package ru.artkolest.spidertestproject.presentation.photo_info

import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import ru.artkolest.spidertestproject.base.BasePresenter
import ru.artkolest.spidertestproject.di.scopes.PhotoInfoScope
import ru.artkolest.spidertestproject.domain.NetworkDataSource
import ru.artkolest.spidertestproject.presentation.list_photos.PhotosContract
import javax.inject.Inject

@PhotoInfoScope
class PhotoInfoPresenter @Inject constructor(
    private val networkDataSource: NetworkDataSource
)
    :  BasePresenter<PhotoInfoContract.View>(), PhotoInfoContract.Presenter{

    override lateinit var view: PhotoInfoContract.View

    override fun start() {
        disposables += networkDataSource.getPhoto(1L, 1)
            .map {
                it
            }
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                view.onSetData(it)
            }, { view.showError(it) })
    }

    fun destroy() = dispose()
}
