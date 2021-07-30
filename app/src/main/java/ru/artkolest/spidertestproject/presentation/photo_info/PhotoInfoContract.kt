package ru.artkolest.spidertestproject.presentation.photo_info

import ru.artkolest.spidertestproject.base.BaseContract
import ru.artkolest.spidertestproject.domain.models.comments.Comments

interface PhotoInfoContract {

    interface View : BaseContract.View {
        fun onSetData(postInfo: List<Comments>)
        fun showError(throwable: Throwable)
        fun onShowErrorToast()
        fun onShowLoad()
        fun onHideLoad()

    }

    interface Presenter : BaseContract.Presenter {
        var view: View
        fun loadImageInfo(postId: String?)

    }
}