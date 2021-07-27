package ru.artkolest.spidertestproject.base

import android.os.Bundle
import androidx.fragment.app.Fragment
import javax.inject.Inject

abstract class BaseFragment<P: BaseContract.Presenter>(contentLayoutId: Int)
    : Fragment(contentLayoutId){

    @Inject
    lateinit var presenter: P

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        createComponent()
    }

    protected abstract fun createComponent()
}