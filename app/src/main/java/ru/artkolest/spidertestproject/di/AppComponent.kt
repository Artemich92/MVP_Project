package ru.artkolest.spidertestproject.di

import dagger.Component
import ru.artkolest.spidertestproject.App
import ru.artkolest.spidertestproject.di.components.MainComponent
import ru.artkolest.spidertestproject.di.components.PhotoInfoComponent
import ru.artkolest.spidertestproject.di.components.PhotosComponent
import ru.artkolest.spidertestproject.di.modules.ApiSourceModule
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
      AppModule::class,
        ApiSourceModule::class,
    ]
)
interface AppComponent {
    fun inject(application: App)
    fun createMainActivity(): MainComponent
    fun createPhotosFragment(): PhotosComponent
    fun createPhotoInfoFragment(): PhotoInfoComponent

}