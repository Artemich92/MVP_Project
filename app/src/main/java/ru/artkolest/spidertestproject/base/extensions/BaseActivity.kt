package ru.artkolest.spidertestproject.base.extensions

import androidx.appcompat.app.AppCompatActivity

abstract class BaseActivity<P: BaseContract.Presenter>
    : AppCompatActivity(), BaseContract.View {
}