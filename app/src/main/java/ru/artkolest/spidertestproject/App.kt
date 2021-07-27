package ru.artkolest.spidertestproject

import android.app.Application
import ru.artkolest.spidertestproject.di.AppComponent
import ru.artkolest.spidertestproject.di.AppModule
import ru.artkolest.spidertestproject.di.DaggerAppComponent
import io.reactivex.disposables.CompositeDisposable

class App: Application() {

    private lateinit var appComponent: AppComponent
    private val disposables = CompositeDisposable()

    override fun onCreate() {
        super.onCreate()
        instance = this
        setupDagger()
    }

    fun getAppComponent(): AppComponent = appComponent

    private fun setupDagger() {
        appComponent = DaggerAppComponent.builder()
            .appModule(AppModule( applicationContext, this))
            .build()
        appComponent.inject(this)
    }

    override fun onTerminate() {
        disposables.dispose()
        super.onTerminate()
    }

    companion object{
        lateinit var instance: App //private set
    }
}