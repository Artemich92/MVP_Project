package ru.artkolest.spidertestproject.presentation.main

import ru.artkolest.spidertestproject.base.BaseContract

interface MainContract {

    interface View : BaseContract.View {
        /* no-op */
    }

    interface Presenter : BaseContract.Presenter {
        var view: View
    }
}