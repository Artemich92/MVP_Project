package ru.artkolest.spidertestproject.presentation.photo_info

import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import ru.artkolest.spidertestproject.base.BasePresenter
import ru.artkolest.spidertestproject.di.scopes.PhotoInfoScope
import ru.artkolest.spidertestproject.domain.NetworkDataSource
import ru.artkolest.spidertestproject.domain.models.comments.Comments
import javax.inject.Inject

@PhotoInfoScope
class PhotoInfoPresenter @Inject constructor(
    private val networkDataSource: NetworkDataSource,
) : BasePresenter<PhotoInfoContract.View>(), PhotoInfoContract.Presenter {

    override lateinit var view: PhotoInfoContract.View
    private var comments = ArrayList<Comments>()

    override fun start() = Unit

    override fun loadImageInfo(postId: String?) {
        view.onShowLoad()
        if (postId.isNullOrEmpty().not()) {
            disposables += networkDataSource.getPostInfo(postId.toString())
                .toObservable()
                .flatMapIterable { it.data }
                .map {
                    comments.add(Comments(it.comment))
                }
                .toList()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .doAfterTerminate { view.onHideLoad() }
                .subscribe({
                    view.onSetData(comments)
                }, { view.showError(it) })
        } else {
            view.onHideLoad()
            view.onShowErrorToast()
        }
    }
}


