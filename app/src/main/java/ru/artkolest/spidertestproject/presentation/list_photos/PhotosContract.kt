package ru.artkolest.spidertestproject.presentation.list_photos

import ru.artkolest.spidertestproject.base.BaseContract
import ru.artkolest.spidertestproject.domain.models.PhotoModel

interface PhotosContract {

    interface View: BaseContract.View{
        fun onSetData(photos: List<PhotoModel>)
        fun showError(throwable: Throwable)

    }

    interface Presenter: BaseContract.Presenter{
        var view: View

    }
}