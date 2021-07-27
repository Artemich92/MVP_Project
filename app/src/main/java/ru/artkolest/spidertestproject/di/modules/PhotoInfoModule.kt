package ru.artkolest.spidertestproject.di.modules

import dagger.Binds
import dagger.Module
import ru.artkolest.spidertestproject.di.scopes.PhotoInfoScope
import ru.artkolest.spidertestproject.presentation.photo_info.PhotoInfoContract
import ru.artkolest.spidertestproject.presentation.photo_info.PhotoInfoPresenter

@Module
interface PhotoInfoModule {

    @PhotoInfoScope
    @Binds
    fun presenter(presenter: PhotoInfoPresenter): PhotoInfoContract.Presenter
}