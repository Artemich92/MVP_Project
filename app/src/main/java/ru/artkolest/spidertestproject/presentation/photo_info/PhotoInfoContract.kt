package ru.artkolest.spidertestproject.presentation.photo_info

import ru.artkolest.spidertestproject.base.BaseContract
import ru.artkolest.spidertestproject.domain.models.PhotoModel

interface PhotoInfoContract {

    interface View: BaseContract.View{
        fun onSetData(photo: List<PhotoModel>)
        fun showError(throwable: Throwable)

    }

    interface Presenter: BaseContract.Presenter{
        var view: View

    }
}