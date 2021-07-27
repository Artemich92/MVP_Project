package ru.artkolest.spidertestproject.presentation.list_photos

import ru.artkolest.spidertestproject.base.BaseContract

interface PhotosContract {

    interface View: BaseContract.View{

    }

    interface Presenter: BaseContract.Presenter{
        var view: View

    }
}