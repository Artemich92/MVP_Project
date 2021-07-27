package ru.artkolest.spidertestproject.di.modules

import dagger.Binds
import dagger.Module
import ru.artkolest.spidertestproject.di.scopes.MainScope
import ru.artkolest.spidertestproject.presentation.main.MainContract
import ru.artkolest.spidertestproject.presentation.main.MainPresenter

@Module
interface MainModule {

    @MainScope
    @Binds
    fun presenter(presenter: MainPresenter): MainContract.Presenter
}