package ru.artkolest.spidertestproject.di.components

import dagger.Subcomponent
import ru.artkolest.spidertestproject.di.modules.PhotosModule
import ru.artkolest.spidertestproject.di.scopes.PhotosScope
import ru.artkolest.spidertestproject.presentation.list_photos.PhotosFragment

@PhotosScope
@Subcomponent(modules = [PhotosModule::class])
interface PhotosComponent {
    fun inject(fragment: PhotosFragment)
}