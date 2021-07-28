package ru.artkolest.spidertestproject.presentation.list_photos

import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import ru.artkolest.spidertestproject.base.BasePresenter
import ru.artkolest.spidertestproject.di.scopes.PhotosScope
import ru.artkolest.spidertestproject.domain.NetworkDataSource
import javax.inject.Inject

@PhotosScope
class PhotosPresenter @Inject constructor(
    private val networkDataSource: NetworkDataSource
): BasePresenter<PhotosContract.View>(),
PhotosContract.Presenter{

    override lateinit var view: PhotosContract.View

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