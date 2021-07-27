package ru.artkolest.spidertestproject.di.components

import dagger.Subcomponent
import ru.artkolest.spidertestproject.di.modules.PhotoInfoModule
import ru.artkolest.spidertestproject.di.scopes.PhotoInfoScope
import ru.artkolest.spidertestproject.presentation.photo_info.PhotoInfoFragment

@PhotoInfoScope
@Subcomponent(modules = [PhotoInfoModule::class])
interface PhotoInfoComponent {
    fun inject(fragment: PhotoInfoFragment)
}