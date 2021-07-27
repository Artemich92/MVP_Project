package ru.artkolest.spidertestproject.di.components

import dagger.Subcomponent
import ru.artkolest.spidertestproject.di.modules.MainModule
import ru.artkolest.spidertestproject.di.scopes.MainScope
import ru.artkolest.spidertestproject.presentation.main.MainActivity

@MainScope
@Subcomponent(modules = [MainModule::class])
interface MainComponent {
    fun inject(activity: MainActivity)
}