package ru.artkolest.spidertestproject.presentation.main

import ru.artkolest.spidertestproject.base.BasePresenter
import ru.artkolest.spidertestproject.di.scopes.MainScope
import javax.inject.Inject

@MainScope
class MainPresenter @Inject constructor(

) : BasePresenter<MainContract.View>(), MainContract.Presenter {

    override lateinit var view: MainContract.View

    override fun start() = Unit


}