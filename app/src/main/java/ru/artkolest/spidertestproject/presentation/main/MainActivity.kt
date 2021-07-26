package ru.artkolest.spidertestproject.presentation.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import ru.artkolest.spidertestproject.R
import ru.artkolest.spidertestproject.base.extensions.BaseActivity

class MainActivity : BaseActivity<MainContract.Presenter>(),
MainContract.View{

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}