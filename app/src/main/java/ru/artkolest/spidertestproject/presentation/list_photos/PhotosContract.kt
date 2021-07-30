package ru.artkolest.spidertestproject.presentation.list_photos

import ru.artkolest.spidertestproject.base.BaseContract
import ru.artkolest.spidertestproject.domain.models.pictures.ImageEntity

interface PhotosContract {

    interface View : BaseContract.View {
        fun onSetData(images: List<ImageEntity>)
        fun showError(throwable: Throwable)
        fun onShowLoad()
        fun onHideLoad()
    }

    interface Presenter : BaseContract.Presenter {
        var view: View
    }
}