package ru.artkolest.spidertestproject.presentation.list_photos

import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import ru.artkolest.spidertestproject.base.BasePresenter
import ru.artkolest.spidertestproject.di.scopes.PhotosScope
import ru.artkolest.spidertestproject.domain.NetworkDataSource
import ru.artkolest.spidertestproject.domain.models.pictures.ImageEntity
import javax.inject.Inject


@PhotosScope
class PhotosPresenter @Inject constructor(
    private val networkDataSource: NetworkDataSource,
) : BasePresenter<PhotosContract.View>(),
    PhotosContract.Presenter {

    override lateinit var view: PhotosContract.View
    private var image = ArrayList<ImageEntity>()

    override fun start() {
        disposables += networkDataSource.getPhotos()
            .toObservable()
            .flatMapIterable { it.data }
            .map {data ->
                data.images?.let {
                    it.forEach { img ->
                        image.add(ImageEntity(data.account_id, img.link, data.account_url, data.id))
                    }
                }
            }
            .toList()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .doOnSubscribe { view.onShowLoad() }
            .doAfterTerminate { view.onHideLoad() }
            .subscribe({
                view.onSetData(image)
            }, { view.showError(it) })
    }
}