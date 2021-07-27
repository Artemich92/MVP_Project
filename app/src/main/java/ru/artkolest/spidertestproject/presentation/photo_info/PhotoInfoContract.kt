package ru.artkolest.spidertestproject.presentation.photo_info

import ru.artkolest.spidertestproject.base.BaseContract

interface PhotoInfoContract {

    interface View: BaseContract.View{

    }

    interface Presenter: BaseContract.Presenter{
        var view: View

    }
}