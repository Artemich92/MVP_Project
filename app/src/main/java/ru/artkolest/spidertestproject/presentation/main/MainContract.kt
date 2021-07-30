package ru.artkolest.spidertestproject.presentation.main

import ru.artkolest.spidertestproject.base.BaseContract

interface MainContract {

    interface View : BaseContract.View {

    }

    interface Presenter : BaseContract.Presenter {
        var view: View
    }
}