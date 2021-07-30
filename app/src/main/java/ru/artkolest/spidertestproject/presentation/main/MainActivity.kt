package ru.artkolest.spidertestproject.presentation.main

import android.os.Bundle
import androidx.navigation.NavController
import androidx.navigation.Navigation
import ru.artkolest.spidertestproject.App
import ru.artkolest.spidertestproject.R
import ru.artkolest.spidertestproject.base.BaseActivity

class MainActivity : BaseActivity<MainContract.Presenter>(),
    MainContract.View {

    private lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        navController = Navigation.findNavController(this, R.id.nav_host_fragment)
        presenter.view = this
    }

    override fun createComponent() =
        App.instance.getAppComponent().createMainActivity().inject(this)
}

